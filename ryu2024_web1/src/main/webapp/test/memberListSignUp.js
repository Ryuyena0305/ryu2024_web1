const MaxMno = () => {
    fetch('/ryu2024_web1/test', { method: 'GET' })
        .then(response => response.json())
        .then(data => {
            let maxMno = 0;

            for (let i = 0; i < data.length; i++) {
                if (data[i].mno > maxMno) {
                    maxMno = data[i].mno;
                }
            }
            document.querySelector('.inputMno').value = maxMno + 1;
        })
        .catch(error => console.error('회원번호 조회 오류:', error));
};

const memberSignUp = () => {
    let inputMno = document.querySelector('.inputMno').value;
    let inputMname = document.querySelector('.inputMname').value;
    let inputMphone = document.querySelector('.inputMphone').value;
    let inputMaddress = document.querySelector('.inputMaddress').value;
    let inputMdate = document.querySelector('.inputMdate').value;
    let inputMgrade = document.querySelector('.inputMgrade').value;
    let inputMcode = document.querySelector('.inputMcode').value;


    if (inputMname == "") {
        alert('회원성명이 입력되지 않았습니다.');
        return;
    }

    let dataObj = {
        mno: parseInt(inputMno),
        mname: inputMname,
        mphone: inputMphone,
        maddress: inputMaddress,
        mdate: inputMdate,
        mgrade: inputMgrade,
        mcode: inputMcode
    };


    const option = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(dataObj)
    };

    fetch('/ryu2024_web1/test', option)
        .then(response => response.json())
        .then(data => {
            if (data == true) {
                alert('회원등록이 완료되었습니다.');
                location.href = "/ryu2024_web1/test/memberList.jsp";
            } else {
                alert('회원등록을 실패하였습니다.');
            }
        })
        .catch(error => {
            alert('시스템 오류: 관리자에게 문의');
            console.error(error);
        });
};

MaxMno();
