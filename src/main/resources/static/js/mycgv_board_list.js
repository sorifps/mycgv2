$(document).ready(function(){

	initAjax(1);

	function initAjax(page){
		$.ajax({
			url: "/board_list_json_data/"+page,
			success : function (result){
				//dhtml을 활용하여 테이블로 출력
				let output = "<table class='board_list'>";
				output += "<tr>";
				output += "<td colspan='5'>";
				output += "<a href='/board_write/'>";
				output += "<button type='button' class='btn_style2' id='btnBoardWrite'>글쓰기</button>";
				output += "</a>";
				output += "</td>";
				output += "</tr>";
				output += "<tr>";
				output += "<th>번호</th>";
				output += "<th>제목</th>";
				output += "<th>조회수</th>";
				output += "<th>작성자</th>";
				output += "<th>작성일자</th>";
				for(obj of result.list){
				output += "</tr>";
				output += "<tr>";
				output += "<td>"+ obj.rno+"</td>";
				output += "<td class='btitle' id='"+obj.bid+"'><a>"+ obj.btitle+"</a></td>";
				output += "<td>"+ obj.bhits+"</td>";
				output += "<td>"+ obj.id+"</td>";
				output += "<td>"+ obj.bdate+"</td>";
				output += "</tr>";
				}
				output += "<tr>";
				output += "<td colspan='5'><div id='ampaginationsm'></div></td>";
				output += "</tr>";
				output += "</table>";
				
				//output을 출력
				
				$("table.board_list").remove();
				$("h1").after(output);
				
				//화면 상에 뿌려진 다음에 이벤트 처리 *중요
				//.content(상세보기) 이벤트
				$(".btitle").click(function (){
					// alert($(this).attr("id"));
					contentAjax($(this).attr("id"), page); //컨텐츠 JSON

				});
				
				
				//페이지 처리 함수 호출
				pager(result.page.pageCount, result.page.dbCount, result.page.pageSize, result.page.reqPage);
				
				//페이지 번호 클릭 호출
				jQuery('#ampaginationsm').on('am.pagination.change',function(e){
					   jQuery('.showlabelsm').text('The selected page no: '+e.page);
			           //$(location).attr('href', "http://localhost:9000/board_list_json.do?page="+e.page);       
			    initAjax(e.page);
			    });
			    
				
				
			} //success
			
		}); //ajax
	} //initAjax

	function contentAjax(bid, page){
		$("table.board_list").remove();
		$("table.board_content").remove();

		$.ajax({
			url : "/board_content_json_data/"+bid,
			success: function (result){
				let output = "<table class=\"board_content\">";
				output += "<tr><th>제목</th>";
				output += "<td>"+result.btitle+"</td></tr>";
				output += "<tr><th>내용</th>";
				output += "<td>"+result.bcontent+"<br><br><br>";
				output += "<c:if test=\"${bvo.bsfile != null }\">";
				output += "<img src=\"http://localhost:9000/upload/${bvo.bsfile }\">";
				output += "</c:if></td></tr><tr>";
				output += "<th>조회수</th>";
				output += "<td>"+result.bhits+"</td></tr><tr>";
				output += "<th>작성자</th>";
				output += "<td>"+result.id+"</td></tr><tr>";
				output += "<th>작성일자</th>";
				output += "<td>"+result.bdate+"</td></tr>";
				output += "<tr><td colspan=\"2\">";
				// output += "<a href='/board_update_json_data/"+result.bid+"/"+page+"'>";
				output += "<button type='button' class='btn_style' id='update'>수정하기</button>"; //</a>
				output += "<button type='hidden' class='btn_style' id='update'>수정하기</button>";
				output += "<button type='button' class='btn_style'>삭제하기</button>";
				output += "<button type='button' class='btn_style' id='list'>리스트</button>";
				output += "<button type='button' class='btn_style' id='home'>홈으로</button>";
				output += "</td></tr></table>";

				$("h1").after(output);

				//리스트 클릭 시
				$("#list").click(function(){
					$("table.board_content").remove();
					initAjax(page);
				});
				//홈으로 클릭 시
				$("#home").click(function(){
					$(location).attr("href", "http://localhost:9000/")
				});
				//수정하기 클릭 시
				// $("#update").click(function(){
				// 	$("table.board_content").remove();
				// 	updateAjax();
				// });


			}
		})
	}









	/* 페이징 처리 함수 */
	function pager(totals, maxSize, pageSize, page) {
		var pager = jQuery('#ampaginationsm').pagination({
		
		    maxSize: maxSize,	    		// max page size
		    totals: totals,	// total pages	
		    page: page,		// initial page 현제 페이지 reqpage
		    pageSize: pageSize,			// max number items per page
		
		    // custom labels		
		    lastText: '&raquo;&raquo;', 		
		    firstText: '&laquo;&laquo;',		
		    prevText: '&laquo;',		
		    nextText: '&raquo;',
				     
		    btnSize:'sm'	// 'sm'  or 'lg'		
		});
		
		
	}



















}); //ready