let params = (new URL(document.location)).searchParams;

function invalidPassword() {
    if(params.get("pass") === 'false') {
        $('.error').css("visibility", "visible");
        console.log("hello");
    }
    console.log("Good");
}

function payment() {
    const xhr = new XMLHttpRequest();
    xhr.open('GET', 'http://localhost:8080/payment?' + 'asd', false);
    xhr.send();
    if (xhr.status === 200) {
        const resp = xhr.responseText;
        xhr.
        console.log(resp);
        if (resp === 'true') {
            alert('Оплата прошла');
        } else {
            alert('Оплата не прошла прошла');
        }
    }
}