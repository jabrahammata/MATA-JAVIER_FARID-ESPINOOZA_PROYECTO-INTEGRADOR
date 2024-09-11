const form = document.getElementById("agregarFormOdont");

form.addEventListener("submit", function (event) {
  event.preventDefault();

  const nombre = document.getElementById("nombre").value;
  const apellido = document.getElementById("apellido").value;
  const matricula = document.getElementById("matricula").value;

  const datosFormulario = {
    nombre,
    apellido,
    numeroDeMatricula: matricula
  };

  fetch(`odontologo/guardar`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(datosFormulario),
  })
    .then((response) => response.json())
    .then((data) => {
      console.log(data);
      alert("Odontólogo agregado con éxito");
      form.reset();
    })
    .catch((error) => {
      console.error("Error agregando odontólogo:", error);
    });
});
