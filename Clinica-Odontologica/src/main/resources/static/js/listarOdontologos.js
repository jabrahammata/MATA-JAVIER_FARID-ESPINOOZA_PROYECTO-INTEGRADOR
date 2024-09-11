
const tableBody = document.querySelector("#odontologoTable tbody");
const editModal = new bootstrap.Modal(document.getElementById("editModal"));
const editForm = document.getElementById("editForm");

let currentOdontologoId;
let currentPacienteId;
let currentDomicilioId;

function fetchPacientes() {

    fetch(`odontologo/buscarTodos`)
    .then((response) => response.json())
    .then((data) => {
        console.log(data);
        tableBody.innerHTML = "";

        data.forEach((odontologo, index) => {
        const row = document.createElement("tr");

        row.innerHTML = `
                <td>${odontologo.id}</td>
                <td>${odontologo.nombre}</td>
                <td>${odontologo.apellido}</td>
                <td>${odontologo.numeroDeMatricula}</td> 
                <td>
                <button class="btn btn-primary btn-sm" onclick="editOdontologo(${odontologo.id}, '${odontologo.apellido}','${odontologo.nombre}', '${odontologo.numeroDeMatricula}')">Modificar</button>
                <button class="btn btn-danger btn-sm" onclick="deleteOdontologo(${odontologo.id})">Eliminar</button>
                </td>
            `;
        tableBody.appendChild(row);
        });
    })
    .catch((error) => {
        console.error("Error fetching data:", error);
    });
}

editOdontologo = function (
    id,
    apellido,
    nombre,
    numeroDeMatricula
) {
    currentOdontologoId = id;
    document.getElementById("editApellido").value = apellido;
    document.getElementById("editNombre").value = nombre;
    document.getElementById("editNumeroDeMatricula").value = numeroDeMatricula;
    editModal.show();
};

editForm.addEventListener("submit", function (event) {
    event.preventDefault();
    const apellido = document.getElementById("editApellido").value;
    const nombre = document.getElementById("editNombre").value;
    const numeroDeMatricula = document.getElementById("editNumeroDeMatricula").value;

    fetch(`odontologo/modificar`, {
    method: "PUT",
    headers: {
        "Content-Type": "application/json",
    },
    body: JSON.stringify({
        id: currentOdontologoId,
        nombre,
        apellido,
        numeroDeMatricula
    }),
    })
    .then((response) => response.json())
    .then((data) => {
        console.log(data);
        alert("Odontólogo modificado con éxito");
        fetchPacientes();
        editModal.hide();
    })
    .catch((error) => {
        console.error("Error editando Odontólogo:", error);
    });
});

deleteOdontologo = function (id) {
    if (confirm("¿Está seguro de que desea eliminar este odontólogo?")) {
    fetch(`odontologo/eliminar/${id}`, {
        method: "DELETE",
    })
        .then((response) => response.json())
        .then((data) => {
        console.log(data);
        alert("Odontólogo eliminado con éxito");
        fetchPacientes();
        })
        .catch((error) => {
            console.error("Error borrando Odontólogo:", error);
        });
    }
};

fetchPacientes();
