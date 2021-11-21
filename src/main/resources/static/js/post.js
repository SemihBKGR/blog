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
        const listItemLink = document.createElement("a")
        listItemLink.href = "#" + subtitle.textContent
        const listItemLinkIcon = document.createElement("span")
        listItemLinkIcon.classList.add("material-icons")
        listItemLinkIcon.textContent = "double_arrow"
        listItemLink.appendChild(listItemLinkIcon)
        const listItemLinkText = document.createElement("span")
        listItemLinkText.textContent = " " + subtitle.textContent
        listItemLink.appendChild(listItemLinkText)
        listItem.appendChild(listItemLink)
        list.appendChild(listItem)
    }
    parent.appendChild(list)
}

function addLinkInSubtitles(contentId) {
    const content = document.getElementById(contentId)
    const subtitles = content.getElementsByTagName("h3")
    for (const subtitle of subtitles) {
        subtitle.id = subtitle.textContent
        const subtiteLink = document.createElement("a")
        subtiteLink.href = "#" + subtitle.id
        subtiteLink.textContent = subtitle.textContent
        subtitle.textContent = ""
        subtitle.appendChild(subtiteLink)
    }
}
