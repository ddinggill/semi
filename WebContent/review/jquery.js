var titleNum;

$(document).ready(function(){
	//댓글입력 시작
	$("#btnInput").on("click",function(){
		$.ajax({
			type:'POST',
			dataType:'text',
			url:'/semi/district/commentAdd.do',
			data: 'num='+$('#boardkey').val()+'&content='+$('#textInput').val()+'&ucd='+$('#ucd').val()+'&fcd='+$('#fcode').val(),
			success:inPutMessage
		});
		
	});//댓글입력 끝
	
	//수정버튼눌렀을시  기존내용가져오기  동적처리  start
	$(document).on("click",'[value="수정"]',function(){
		$("#divUpdate").css({display:'block'});
		$("#commentAdd").css({display:'none'});
		
		//수정버튼 누른거의 부모
		var selEle=$(this).parent();
		$("#textCol").val($(selEle).children('input[name="rkey"]').val());
		$("#textUpdate").val(selEle.children('p:nth-child(2)').text());
	});
	//수정버튼 눌렀을시 동적 처리 end 
	
	//댓글수정버튼
	$("#btnUpdate").on("click",function(){
		$.ajax({
			type:'POST',
			dataType:'text',
			url:'/semi/district/CommentUpdate.do',
			data:'num='+$("#textCol").val()+'&content='+$("#textUpdate").val(),
			success:updateMessage
		})
	});
	//end 댓글수정버튼
	
	//댓글삭제버튼
	$(document).on("click",'[value="삭제"]',function(){
		//삭제버튼 누른거의 부모
		var selEle=$(this).parent();
		var col = $(selEle).children('input[name="rkey"]').val();
		$.ajax({
			type:'POST',
			dataType:'text',
			url:'/semi/district/CommentDel.do',
			data:'rkey='+col,
			success:deleteMessage
		})
		
	});//end 댓글삭제버튼
	
});//end ready()

//댓글삭제
function deleteMessage(res){
	$("#commentList").empty();
	listView(res);
}//end deleteMessage()

//댓글수정
function updateMessage(res){
	$("#commentList").empty();
	$("#divUpdate").css({display:'none'});
	$("#commentAdd").css({display:'block'});
	listView(res);
}//end updateMessage

//댓글 삽입 응답
function inPutMessage(res){
	$("#commentList").empty();
	listView(res);
	$("#textInput").val("");
}//end inPutMessage()

//댓글 리스트 요청
function listView(num){
	titleNum=num;
	$.ajax({
		type:'GET',
		dataType:'json',
		url:'/semi/district/commentList.do?num='+$('#boardkey').val(),
		success:viewMessage
	});
}//end listView()
  
//댓글리스트 응답
function viewMessage(res){

	for(index in res){
		var div=$("<div class='recomment' style='border:1px dotted gray'></div>");
		$("#commentList").append(div);
		var p1=$('<p style="font-weight : bold; margin-bottom:5px" >'+res[index].nm+'</p>');
		$(div).append(p1);
		var p2=$('<p style="margin-bottom:5px">'+res[index].con+'</p>');
		$(div).append(p2);
		var p3=$('<input type="hidden" id="rkey" name="rkey" value='+res[index].rkey+'>');
		$(div).append(p3);
/*		console.log("유저코드"+res[index].usercode);
		console.log("접속유저코드"+res[index].conUser);*/
		if (res[index].usercode == res[index].conUser) {
	         var inputupdate=$('<input type="button" value="수정"/>');
	         $(div).append(inputupdate);
	         var inputdelete=$('<input type="button" value="삭제"/>');
	         $(div).append(inputdelete);
	    }
		
	}
}//end viewMessage()

