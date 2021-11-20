function convertUnixTimeToDate(unixTimestamp) {
    const date = new Date(unixTimestamp * 1000)
    const year = date.getFullYear()
    const month = date.getMonth()
    const day = date.getDay()
    //return month + '/' + day + '/' + year
    return '00/00/0000'
}

function addPadDiv(divName) {
    const row = document.getElementsByClassName("row").item(0)
    const padColDiv = document.createElement("div")
    padColDiv.classList.add("col")
    const padSubjectDiv = document.createElement("div")
    padSubjectDiv.classList.add(divName)
    padColDiv.appendChild(padSubjectDiv)
    row.appendChild(padColDiv)
}
