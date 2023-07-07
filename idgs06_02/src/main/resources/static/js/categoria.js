
const API_URL = "http://localhost:8081";


function entrar() {
    console.log("entrando...");
    listarCategorias();
//    const formA = document.getElementById('formulario');
//    formA.addEventListener('submit', function (e) {
//        e.preventDefault();
//        enviarFrmAdd();
//    });
}


async function listarCategorias() {
    const HTMLResponse = document.querySelector("#tbl-catego");

    await fetch(`${API_URL}/api/categorias`)
            .then((response) => response.json())
            .then((categorias) => {
                console.log(categorias);
                if (categorias.length > 0) {
                    categorias.forEach((cat) => {
                        let elemTr = document.createElement("tr");
                        let elemTd1 = document.createElement("td");
                        let elemTd2 = document.createElement("td");
                        let elemTd3 = document.createElement("td");
                        elemTd1.innerHTML = `${cat.id}`;
                        elemTd2.innerHTML = `${cat.categoriaProd}`;
                        elemTd3.innerHTML = `
                        <a href="/categorias/editar/${cat.id}">Editar</a>
                        <a href="/categorias/borrar/${cat.id}">Borrar</a>`;
                        elemTr.appendChild(elemTd1);
                        elemTr.appendChild(elemTd2);
                        elemTr.appendChild(elemTd3);
                        HTMLResponse.appendChild(elemTr);
                    });
                }
            });
}


async function enviarFrmAdd() {
    console.log("entro agregar...");
    let id = 0;
    let cat = document.getElementById('categoria').value;
    let act = document.getElementById('activo').value === 'on' ? true : false;
    const params = {
        id: id,
        categoriaProd: cat,
        activo: act
    };
    const options = {
        method: 'POST',
        headers: {'Content-type': 'application/json'},
        body: JSON.stringify(params)
    };

    await fetch(`${API_URL}/api/categorias`, options)
            .then((response) => {
                if (response.ok) {
                    alert(params.categoriaProd +' Guardado correctamente');
                    listarCategorias();
                } else {
                    console.log(response);
                    alert('Hubo un error, favor de revisar los datos');
                }
            })
            .catch((exception) => {
                console.log(exception);
            });
}


function convertir(nombreInput) {
    nombreInput.value = nombreInput.value.toUpperCase();
}

