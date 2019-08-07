package model.festival;

import java.util.Date;

public class FestDTO {
	private int fcode;
	private String  ftitle;
	private Date  fsdate;
	private Date  fedate;
	private String  faddress;
	private String  fcontents;
	private String  fimgpath;
	private String  fmainpath;
	private String fmap;
	private int fview;
	private int floc;
	private int recommend;
	
	public FestDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public String getFmap() {
		return fmap;
	}




	public void setFmap(String fmap) {
		this.fmap = fmap;
	}

	public int getFcode() {
		return fcode;
	}

	public void setFcode(int fcode) {
		this.fcode = fcode;
	}

	public String getFtitle() {
		return ftitle;
	}

	public void setFtitle(String ftitle) {
		this.ftitle = ftitle;
	}

	public Date getFsdate() {
		return fsdate;
	}

	public void setFsdate(Date fsdate) {
		this.fsdate = fsdate;
	}

	public Date getFedate() {
		return fedate;
	}

	public void setFedate(Date fedate) {
		this.fedate = fedate;
	}

	public String getFaddress() {
		return faddress;
	}

	public void setFaddress(String faddress) {
		this.faddress = faddress;
	}

	public String getFcontents() {
		return fcontents;
	}

	public void setFcontents(String fcontents) {
		this.fcontents = fcontents;
	}

	public String getFimgpath() {
		return fimgpath;
	}

	public void setFimgpath(String fimgpath) {
		this.fimgpath = fimgpath;
	}

	
	public String getFmainpath() {
		return fmainpath;
	}

	public void setFmainpath(String fmainpath) {
		this.fmainpath = fmainpath;
	}

	public int getFview() {
		return fview;
	}

	public void setFview(int fview) {
		this.fview = fview;
	}

	public int getFloc() {
		return floc;
	}

	public void setFloc(int floc) {
		this.floc = floc;
	}

	public int getRecommend() {
		return recommend;
	}

	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}

}
