<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
    //�� ���������� ���θ� �ּ� ǥ�� ��Ŀ� ���� ���ɿ� ����, �������� �����͸� �����Ͽ� �ùٸ� �ּҸ� �����ϴ� ����� �����մϴ�.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // �˾����� �˻���� �׸��� Ŭ�������� ������ �ڵ带 �ۼ��ϴ� �κ�.

                // ���θ� �ּ��� ���� ��Ģ�� ���� �ּҸ� ǥ���Ѵ�.
                // �������� ������ ���� ���� ��쿣 ����('')���� �����Ƿ�, �̸� �����Ͽ� �б� �Ѵ�.
                var roadAddr = data.roadAddress; // ���θ� �ּ� ����
                var extraRoadAddr = ''; // ���� �׸� ����

                // ���������� ���� ��� �߰��Ѵ�. (�������� ����)
                // �������� ��� ������ ���ڰ� "��/��/��"�� ������.
                if(data.bname !== '' && /[��|��|��]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // �ǹ����� �ְ�, ���������� ��� �߰��Ѵ�.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // ǥ���� �����׸��� ���� ���, ��ȣ���� �߰��� ���� ���ڿ��� �����.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // �����ȣ�� �ּ� ������ �ش� �ʵ忡 �ִ´�.
                document.getElementById('sample4_postcode').value = data.zonecode;
                document.getElementById("sample4_roadAddress").value = roadAddr;
                document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
         
                document.getElementById("sample4_engAddress").value = data.addressEnglish;
                       
                // �����׸� ���ڿ��� ���� ��� �ش� �ʵ忡 �ִ´�.
                if(roadAddr !== ''){
                    document.getElementById("sample4_extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("sample4_extraAddress").value = '';
                }

                var guideTextBox = document.getElementById("guide");
                // ����ڰ� '���� ����'�� Ŭ���� ���, ���� �ּҶ�� ǥ�ø� ���ش�.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(���� ���θ� �ּ� : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(���� ���� �ּ� : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
    }
</script>
</head>
<body>
<form action="SignUpC" onsubmit="return check()">
	<table class="signupTbl">	
	<tr>
	 <td colspan="2"> <h1>&nbsp;&nbsp;ȸ������</h1> 
	 	  <div id="signupHead"></div>
	 </td>
	</tr>
	<tr>
		<td colspan="2" style="color: white;">-----------</td>
	</tr>
	<tr>
		<td>&nbsp;&nbsp;�� ��</td>
		<td><input name="name" required="required"></td>
	</tr>
	<tr>
		<td> &nbsp;&nbsp;ID</td>
		<td><input name="id" placeholder="�ѱ� �� 5���� �̻�"></td>
	</tr>
	<tr>
		<td>&nbsp;&nbsp;PW</td>
		<td><input name="pw" type="password" placeholder="3���� �̻�, ��,��,�� 1����"></td>
	</tr>
	<tr>
		<td>&nbsp;&nbsp;PW Ȯ��</td>
		<td><input name="pw" type="password"></td>
	</tr>
	<tr>
	<td>&nbsp;&nbsp;����</td>
	 <td>
			��<input type="radio" name="gender" checked="checked" value="��">
		    ��<input type="radio" name="gender" value="��">	 
	 </td>
	</tr>
	<tr>
		<td colspan="2" style="color: white;">-----------</td>
	</tr>
	<tr>
	 <td>&nbsp;&nbsp;��ȭ��ȣ</td>
	 <td> <input name="num1" size="3" value="010">-<input name="num2" size="5">-<input name="num3" size="5"> </td>
	</tr>
	<tr>
		<td colspan="2" style="color: white;">-----------</td>
	</tr>
	<tr>
	 <td colspan="2"> &nbsp;&nbsp;�ּ� <p>
	 	<input type="text" id="sample4_postcode" placeholder="�����ȣ">
		<input type="button" onclick="sample4_execDaumPostcode()" value="�����ȣ ã��"><br>
		<input type="text" id="sample4_roadAddress" placeholder="���θ��ּ�" size="60" ><br>
		<input type="hidden" id="sample4_jibunAddress" placeholder="�����ּ�"  size="60">
		<span id="guide" style="color:#999;display:none"></span>
		<input type="text" id="sample4_detailAddress" placeholder="���ּ�"  size="60"><br>
		<input type="hidden" id="sample4_extraAddress" placeholder="�����׸�"  size="60">
		<input type="hidden" id="sample4_engAddress" placeholder="�����ּ�"  size="60" ><br>
<!-- 
String  addr1= multi.getParameter("postAddr1");
String  addr2= multi.getParameter("postAddr2");
String  addr3= multi.getParameter("postAddr3");
String addr = addr1+" "+addr2+" "+addr3;
 -->		
	 </td>
	</tr>
	<tr id="signupTr12">
	 <td colspan="2"> 
		  <div id="button-1">
    		<div id="eff-1"></div>
    		<a href="#"> �����ϱ� </a>
  		 </div>
	 </td>
	</tr>	
	</table>
</form>
</body>
</html>