function reportError(event) {
    fetch(event.filename, {method: 'GET'})
        .then(function(result) {
            result.text().then(text => {
                let encodedFile = window.btoa(text);
                let body = {
                    time: new Date().toISOString(),
                    message: event.message,
                    filename: event.filename,
                    file: encodedFile,
                    lineno: event.lineno,
                    colno: event.colno,
                    useragent: navigator.userAgent,
                    hostname: window.location.hostname,
                    href: window.location.href
                };
                fetch('/error/report', {
                    method: 'POST',
                    body: JSON.stringify(body),
                    headers: new Headers({
                        'Content-Type': 'application/json'
                    })
                })
                .catch(error => console.log(error));
            });
        });
}

window.addEventListener("error", reportError);
