document.addEventListener("DOMContentLoaded", () => {
    const careerBtn = document.querySelector("button.button.career");
    const eduBtn = document.querySelector("button.button.edu");
    const certBtn = document.querySelector("button.button.cert");

    careerBtn?.addEventListener("click", () => {
        document.location.href = "/update?category=career";
    })

    eduBtn?.addEventListener("click", ()=> {
        document.location.href = "/update?category=edu";
    })

    certBtn?.addEventListener("click", ()=> {
        document.location.href = "/update?category=cert";
    })
})