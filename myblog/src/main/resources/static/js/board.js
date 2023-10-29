document.addEventListener("DOMContentLoaded", ()=> {
    const board_write_btn = document.querySelector("button.board.button.write");
    const category_list = document.querySelector("ul.board.category");
    const board_table = document.querySelector("table.board.list");

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

    const trClickHandler = (e) => {
        const td = e.target;
        if (td.tagName === "TD") {
            const tr = td.closest("TR");
            // alert(tr.className);
            const seq = tr.className;
            document.location.href = `board/detail?seq=${seq}`;
        }
    }
    board_table?.addEventListener("click", trClickHandler);
})