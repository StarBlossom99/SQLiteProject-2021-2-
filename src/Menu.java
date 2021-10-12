
public class Menu {
	public static void displaymenu()
    {
        System.out.println();
        System.out.println("1. <항목 추가> ( add )");
        System.out.println("2. <항목 삭제> ( del )");
        System.out.println("3. <항목 수정> ( edit )");
        System.out.println("4. <전체 목록> ( ls )");
        System.out.println("5. <완료 항목 목록> ( ls_comp )");
        System.out.println("6. <완료 항목 설정> ( comp )");
        System.out.println("7. <제목 정렬> ( ls_name_asc )");
        System.out.println("8. <제목 역순 정렬> ( ls_name_desc )");
        System.out.println("9. <날짜순 정렬> ( ls_date_asc )");
        System.out.println("10. <날짜역순 정렬> ( ls_date_desc )");
        System.out.println("11. <도움말> ( help )");
        System.out.println("12. <성취도> ( achi )");
        System.out.println("13. <제목 검색> ( find )");
        System.out.println("14. <카테고리 검색> ( find_cate )");
        System.out.println("15. <카테고리 목록> ( ls_cate )");
        System.out.println("16. <프로그램 종료> (exit)");
   
    }
    
    public static void prompt() {
    	displaymenu();
    }
}
