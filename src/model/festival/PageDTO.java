package model.festival;

/*
 * 페이지 처리에 관련된 데이터 모델
 * 작성자 : 박종현
 * 작성일 : 2019.08.13
 */
public class PageDTO {
	private int currentPage; // 현재페이지
	private int totalCount; // 총 레코드수
	private int blockCount = 5; // 한 페이지에 보여줄 레코드수
	private int blockPage = 5; // 한 블록에 보여줄 페이지수
	private int totalPage; // 총 페이지수
	private int startRow; // 시작 레코드 번호
	private int endRow; // 끝 레코드번호
	private int startPage; // 한 블록의 시작 페이지 번호
	private int endPage; // 한 블록의 끝페이지 번호
	private int number; //시퀀스와 상관없는 리스트의 레코드 번호
	private String searchKey; //검색할 속성
	private String searchWord; //검색어
	
	public PageDTO() {

	}
	
	public PageDTO(int currentPage, int totalCount , String searchKey , String searchWord) {
		this(currentPage,totalCount);
		this.searchKey = searchKey;
		this.searchWord = searchWord;
	}
	
	public PageDTO(int currentPage, int totalCount) {
		this.currentPage = currentPage; //현제 페이지
		this.totalCount = totalCount;  //전체 레코드 수

		// 총페이지수
		totalPage = totalCount / blockCount +
				    (totalCount % blockCount == 0 ? 0 : 1);
		
		if (totalPage < currentPage)
			this.currentPage = totalPage;//마지막 페이지 

		// 시작레코드
		startRow = (this.currentPage - 1) * blockCount + 1;
						//현재페이지			보여줄 레코드의 수
		// 끝레코드
		endRow = startRow + blockCount - 1;
				//시작레코드 	보여줄 레코드의 수
		// 시작페이지
		startPage = (int) ((this.currentPage - 1) / blockPage) * blockPage + 1;
			
		// 끝페이지
		endPage = startPage + blockPage - 1;
		if (totalPage < endPage)
			endPage = totalPage;

		// 리스트페이지에 출력번호     시퀀스랑 상관없이 게시물의 순서대로 출력 =공부 x
		//사용법 > <td>${pdto.number}</td> 
		number = totalCount - (this.currentPage - 1) * blockCount;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getBlockCount() {
		return blockCount;
	}
	public void setBlockCount(int blockCount) {
		this.blockCount = blockCount;
	}
	public int getBlockPage() {
		return blockPage;
	}
	public void setBlockPage(int blockPage) {
		this.blockPage = blockPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getEndRow() {
		return endRow;
	}
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getSearchKey() {
		return searchKey;
	}
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
	public String getSearchWord() {
		return searchWord;
	}
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}
	
}
