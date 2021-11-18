function convertUnixTimeToDate(unixTimestamp) {
    const date = new Date(unixTimestamp * 1000)
    const year = date.getFullYear()
    const month = date.getMonth()
    const day = date.getDay()
    return month + '/' + day + '/' + year
}