let chk1 = document.getElementById("checkbox");
let chk2 = document.getElementById("chk2");
const CurrStatus = document.getElementById('CurrStatus');

/* 이미 등록된 기록에서 chk정보를 불러와서 그 효과를 위한 함수 */
function showChk1(sign) {
    console.log("data.chk1 : ", sign)
    document.getElementById("checkbox").checked = sign;
    approved();
}

function showChk2(sign) {
    console.log("data.chk2 : ", sign)
    document.getElementById("chk2").checked = sign;
    mutuallyApproved(sign);
}

/* 결재 체크박스 체크되면 밸류 바꾸기 */
/* 결재 체크박스 체크되면 인풋 수정 불가 */
function approved() {
    const mtable = document.getElementById('main-table');
    const inputElements = mtable.querySelectorAll('.input');
    //const chk = document.getElementById('checkbox');
    if (chk1.checked) {
        chk1.value = '1';

        // 거래처정보 인풋 비활성화
        inputElements.forEach(function(input) {
            input.disabled = true;
            input.style.backgroundColor = "#F2F2F2";
            input.style.color = "black"
        });
        submitCheck();
    } else {
        chk1.value = '0';
        // 결재 취소하면 다시 활성화
        inputElements.forEach(function(input) {
            input.disabled = false;
            input.style.backgroundColor = "#fff";
        });
    }
}

function mutuallyApproved(sign) {
    // chk2를 누르면 chk1 이 자동으로 체크된다.
    showChk1(sign)
}


function submitCheck() {
    CurrStatus.options[3].selected = true;
    //CurrStatus.disabled = true;
}