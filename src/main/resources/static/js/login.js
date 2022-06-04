const $btn = document.querySelector('#reg-btn'),
    $checkbox = document.querySelector('#checkbox');

$checkbox.addEventListener('change', () =>
{
    if($checkbox.checked)
    {
        $btn.disabled = false;
    }
    else
    {
        $btn.disabled = true;
    }
});

function changeDisplay(typeDisplay) {
    if (typeDisplay === 'LogIn') {
        document.getElementById("authorization").style.display = "none";
        document.getElementById("login").style.display = "block";
    }
    if (typeDisplay === 'Authorization') {
        document.getElementById("login").style.display = "none";
        document.getElementById("authorization").style.display = "block";
    }
}