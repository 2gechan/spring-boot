document.addEventListener("DOMContentLoaded", ()=> {
    const board_write_btn = document.querySelector("button.board.button.write");
    const category_list = document.querySelector("ul.board.category");

    board_write_btn?.addEventListener("click", ()=> {
        document.location.href = "/board/write";
    })

    const categoryClick = (e) => {
        const target = e.target;
        const targetClassName = target.className;
        // alert(targetClassName);
        if (target.tagName === "LI") {
            document.location.href = `/board?ca=${targetClassName}`;
        }
    }
    category_list?.addEventListener("click", categoryClick);
})