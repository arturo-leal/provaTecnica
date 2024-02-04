function buscarSaldo(url, payload, resultElement, errorMessage) {
    return fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(payload)
    })
        .then(response => response.json())
        .then(data => {
            let saldo;
            if (data.saldo !== null) {
                saldo = data.saldo;
            } else {
                saldo = errorMessage;
            }

            // Si es búsqueda por fecha, formateamos la fecha
            if (payload.fecha) {
                payload.fecha = payload.fecha.split("-").reverse().join("-");
            }

            document.getElementById(resultElement).innerText = "El saldo " + (payload.numeroCaja ? "de la caja " + payload.numeroCaja : "para la fecha " + payload.fecha) + " es: " + saldo;
            document.getElementById(resultElement + 'Container').style.display = 'block';
        })
        .catch(error => {
            console.error('Error al realizar la solicitud:', error);
        });
}

function search(event) {
    event.preventDefault();

    let caja = document.getElementById("cajaRegistradora").value;
    let fecha = document.getElementById("fecha").value;

    buscarSaldo("http://localhost:8080/api/v1/cajaRegistradora/getSaldoCaja", {
        numeroCaja: caja,
        fecha: fecha
    }, "saldoResultado", "No hay saldo para la fecha seleccionada");
}

function searchByDate(event) {
    event.preventDefault();

    let fecha = document.getElementById("fechaSolo").value;

    buscarSaldo("http://localhost:8080/api/v1/cajaRegistradora/getSaldoCajaByDate", {
        fecha: fecha,
        numeroCaja: null
    }, "saldoResultadoSoloFecha", "No hay saldo para la fecha seleccionada");
}
