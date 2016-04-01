package cn.edu.fjnu.towide.city_management.common;
/**
 * @author  LBB
 * @date 创建时间：2016年1月24日 下午2:17:25
 * @version 1.0 
 * @parameter 
 * @since  
 * @return 
 */

public class PageParam {
    private int currentPage=0 ; // 当前页
	
	private int totalPage ; // 总页
	
	private int rowCount ; // 总记录数

	public static int pageSize = 10; // 页大小
	private Object data; // 数据
	private int startRow;// 索引开始值
	private int endRow;//索引结束值
	public PageParam() {
		super();
	}
	public PageParam(int currentPage, int totalPage, int rowCount, Object data,int startRow, int endRow) {
	super();
	this.currentPage=currentPage;
	this.totalPage = totalPage;
	this.rowCount = rowCount;
	this.data = data;
	this.startRow = startRow;
	this.endRow = endRow;
}

	public PageParam paging(PageParam pageParam) {
		pageParam.setCurrentPage((pageParam.getCurrentPage() == 0) ? 1 : pageParam.getCurrentPage());
		pageParam.setTotalPage((pageParam.getRowCount() - 1) / pageParam.getPageSize() + 1);
		pageParam.setStartRow((pageParam.getCurrentPage() - 1) * pageParam.getPageSize());
		pageParam.setEndRow((pageParam.getCurrentPage() == pageParam.getTotalPage()) ? pageParam.getRowCount()
				: (pageParam.getStartRow() + pageParam.getPageSize()));
		return pageParam;

	}
    
	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage=currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage =totalPage;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getStartRow() {
		return startRow;
	}


	public void setStartRow(int startRow) {
		this.startRow=startRow;
	}


	public int getEndRow() {
		return endRow;
	}


	public void setEndRow(int endRow) {
		this.endRow = startRow;
	}

}
