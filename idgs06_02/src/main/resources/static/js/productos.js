const API_URL = "http://localhost:8081";

function entrar() {
  console.log("entrando...");
  listarProductos();
  //    const formA = document.getElementById('formulario');
  //    formA.addEventListener('submit', function (e) {
  //        e.preventDefault();
  //        enviarFrmAdd();
  //    });
  getCategorias();
}
let idCategoria;

const getCategorias = async () => {
  await fetch(`${API_URL}/api/categorias`)
    .then((response) => {
      if (response.ok) {
        console.log("soy response de cuantas categorias hay", response);
        return response.json(); // Parsear la respuesta como JSON
      } else {
        console.log(response);
        alert("Hubo un error, favor de revisar los datos");
      }
    })
    .then((data) => {
      const seleccionado = document.getElementById("seleccionarCategoria");
      seleccionado.innerHTML = ""; // Limpiar el contenido existente del select

      // Construir las opciones del select a partir de los datos recibidos
      const opciones = document.createElement("option");
      opciones.text = "*Selecciona una categoría*";
      seleccionado.appendChild(opciones);

      data.forEach((categoria) => {
        const option = document.createElement("option");
        option.value = categoria.id; // Asignar el valor del id a la opción
        option.text = categoria.categoriaProd; // Suponiendo que la categoría tiene un atributo "nombre"
        seleccionado.appendChild(option);
      });

      seleccionado.addEventListener("change", () => {
        const selecion = seleccionado.value;
        console.log("Valor seleccionado:", selecion);
        idCategoria = selecion;
      });
    })
    .catch((exception) => {
      console.log(exception);
    });
};

async function listarProductos() {
  const HTMLResponse = document.querySelector("#tbl-productos");

  await fetch(`${API_URL}/api/productos`)
    .then((response) => response.json())
    .then((productos) => {
      console.log("soy producto", productos);

      if (productos.length > 0) {
        productos.forEach((cat) => {
          let elemTr = document.createElement("tr");
          let elemTd1 = document.createElement("td");
          let elemTd2 = document.createElement("td");
          let elemTd3 = document.createElement("td");
          let elemTd4 = document.createElement("td");
          elemTd1.innerHTML = `${cat.id}`;
          elemTd2.innerHTML = `${cat.producto}`;
          elemTd3.innerHTML =
            cat.categoria !== null
              ? cat.categoria.categoriaProd
              : "*SIN CATEGORIA*";
          elemTd4.innerHTML = `
                        <a href="/categorias/editar/${cat.id}">Editar</a>
                        <a href="/categorias/borrar/${cat.id}">Borrar</a>`;
          elemTr.appendChild(elemTd1);
          elemTr.appendChild(elemTd2);
          elemTr.appendChild(elemTd3);
          elemTr.appendChild(elemTd4);
          HTMLResponse.appendChild(elemTr);
        });
      }
    });
}

async function enviarFrmAdd() {
  if (idCategoria === "*Selecciona una categoría*") {
    const errorCatDiv = document.getElementById("errorCat");
    errorCatDiv.textContent = "Selecciona una categoria"; //
  } else {
    console.log("entro agregar...");
    let id = 0;
    let produc = document.getElementById("producto").value;
    let act = document.getElementById("activo").value === "on" ? true : false;
    const params = {
      id: id,
      producto: produc,
      activo: act,
      categoria: { id: idCategoria },
    };
    const options = {
      method: "POST",
      headers: { "Content-type": "application/json" },
      body: JSON.stringify(params),
    };

    await fetch(`${API_URL}/api/productos`, options)
      .then((response) => {
        if (response.ok) {
          alert(params.producto + " Guardado correctamente");
          listarProductos();
          location.reload();
        } else {
          console.log(response);
          alert("Hubo un error, favor de revisar los datos");
        }
      })
      .catch((exception) => {
        console.log(exception);
      });
  }
}

function convertir(nombreInput) {
  nombreInput.value = nombreInput.value.toUpperCase();
}
