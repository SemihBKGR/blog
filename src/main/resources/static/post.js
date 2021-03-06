function addSubtitleList(parentId, contentId) {
    const parent = document.getElementById(parentId)
    const content = document.getElementById(contentId)
    const subtitles = content.getElementsByTagName("h3")
    const list = document.createElement("ul")
    list.classList.add("list-group")
    for (const subtitle of subtitles) {
        const listItem = document.createElement("li")
        listItem.classList.add("list-group-item")
        listItem.classList.add("border-0")
        listItem.style.padding = "0"
        const link = document.createElement("a")
        link.href = "#" + subtitle.textContent
        link.classList.add("text-dark")
        const linkIcon = document.createElement("span")
        linkIcon.classList.add("material-icons")
        linkIcon.style.fontSize = "small"
        linkIcon.textContent = "double_arrow"
        link.appendChild(linkIcon)
        const listItemLinkText = document.createElement("span")
        listItemLinkText.textContent = " " + subtitle.textContent
        link.appendChild(listItemLinkText)
        listItem.appendChild(link)
        list.appendChild(listItem)
    }
    parent.appendChild(list)
}

function addLinkInSubtitles(contentId) {
    const content = document.getElementById(contentId)
    const subtitles = content.getElementsByTagName("h3")
    for (const subtitle of subtitles) {
        subtitle.id = subtitle.textContent
        subtitle.classList.add("text-dark")
        const link = document.createElement("a")
        link.href = "#" + subtitle.textContent
        link.style.display = "none";
        const linkIcon = document.createElement("span")
        linkIcon.classList.add("material-icons")
        linkIcon.style.color = "gray"
        linkIcon.style.marginLeft = "5px"
        linkIcon.textContent = "link"
        subtitle.addEventListener("mouseover", function (event) {
            link.style.display = "inline";
        })
        subtitle.addEventListener("mouseleave", function (event) {
            link.style.display = "none";
        })
        linkIcon.addEventListener("mouseover", function (event) {
            linkIcon.style.color = "black"
        })
        linkIcon.addEventListener("mouseleave", function (event) {
            linkIcon.style.color = "gray"
        })
        link.appendChild(linkIcon)
        subtitle.appendChild(link)
    }
}

function trimCodes(contentId) {
    const content = document.getElementById(contentId)
    const codes = content.getElementsByTagName("code")
    for (const code of codes) {
        code.textContent = code.textContent.trim();
    }
}
