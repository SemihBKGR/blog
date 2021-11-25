function convertUnixTimeToDate(unixTimestamp) {
    const date = new Date(unixTimestamp * 1000)
    console.log(date)
    const year = date.getFullYear()
    const month = date.getMonth() + 1
    const day = date.getDate()
    return month + '/' + day + '/' + year
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
