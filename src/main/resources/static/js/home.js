function changeCategory(category) {
    let apps = document.getElementsByClassName("apps");
    for (let i = 0; i < apps.length; i++) {
        apps[i].style.display = 'none';
    }
    let current = document.getElementsByClassName(category)[0];
    if (screen.width > 1000) {
        current.style.display = "flex";
        current.style.flexDirection="row";
        current.style.justifyContent="space-between";
        current.style.width='100%';
    }
    else {
        current.style.display = "flex";
        current.style.flexDirection="column";
        current.style.alignContent='space-between';
        current.style.width='100%';
    }

    let lines = document.getElementsByClassName("line");
    for (let i = 0; i < lines.length; i++) {
        lines[i].style.border='#666666 solid 1px';
    }

    let currentLine = document.getElementsByClassName(category+"-line")[0];
    currentLine.style.border='#e95420 solid 1px';

    let links = document.getElementsByClassName("category-a");
    for (let i = 0; i < links.length; i++) {
        links[i].style.color='#999999';
    }

    let currentLink = document.getElementsByClassName(category+"-a")[0];
    currentLink.style.color='#ffffff';

}

function changeColor(element) {
    if (element.style.color==="white")
        element.style.color="#999999";
    else
        element.style.color="white";
}