document.addEventListener("DOMContentLoaded", ()=> {
    const board_write_btn = document.querySelector("button.board.button.write");

    board_write_btn?.addEventListener("click", ()=> {
        document.location.href = "/board/write";
    })
})