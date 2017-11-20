package com.wzx.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wzx.basedao.BaseDao;
import com.wzx.dao.inter.INewsDao;
import com.wzx.dto.FenYe;
import com.wzx.dto.NewsDto;
import com.wzx.dto.Query;
import com.wzx.util.DataSourceUtil;
@SuppressWarnings("unchecked")
public class NewsDao extends BaseDao implements INewsDao{
	/*
	 * 1.根据id删除新闻-- 
	 * 2.查询所有的新闻-- 
	 * 3.根据标题,内容模糊查询新闻 like --- 
	 * 4.添加新闻
	 * 5.根据id修改新闻
	 * 6.根据id查询新闻
	 */

	public int addNews(NewsDto n) {
		List<Object> args = new ArrayList<Object>();
		String sql = "insert into news(newsid,title,context,newsman,newsdate,pic) values(?,?,?,?,?,?)";
		args.add(n.getNewsid());
		args.add(n.getTitle());
		args.add(n.getContext());
		args.add(n.getNewsman());
		args.add(n.getNewsdate());
		args.add(n.getPic());
		return update(args, sql);
	}

	public int update(NewsDto n) {
		List<Object> args = new ArrayList<Object>();
		String sql = "update news set newsid=? ";
		args.add(n.getNewsid());
		if(n.getTitle()!=null && !"".equals(n.getTitle())){
			sql+=",title=?";
			args.add(n.getTitle());
		}
		if(n.getContext()!=null && !"".equals(n.getContext())){
			sql+=",context=?";
			args.add(n.getContext());
		}
		if(n.getNewsman()!=null && !"".equals(n.getNewsman())){
			sql+=",newsman=?";
			args.add(n.getNewsman());
		}
		if(n.getNewsdate()!=null){
			sql+=",newsdate=?";
			args.add(n.getNewsdate());
		}
		if(n.getPic()!=null && !"".equals(n.getPic())){
			sql+=",pic=?";
			args.add(n.getPic());
		}
		sql+="where id=?";
		args.add(n.getId());
		return update(args, sql);
	}

	public int del(String id) {
		List<Object> args = new ArrayList<Object>();
		String sql = "update news set yes='no' where id=?";
		args.add(id);
		return update(args, sql);
	}

	// ----------------------------------------------------------------------

	public List<NewsDto> getAllNews() {
		String sql = "select * from news where yes='yes' order by newsdate asc";
		List<Object> args=new ArrayList<Object>();
		return query(args, sql);
	}

	
	public List<NewsDto> queryTitle(Query query) {
		List<Object> args=new ArrayList<Object>();
		String sql = "select * from news where 1=1  ";
		if(query.getQtitle()!=null && !"".equals(query.getQtitle())){
			sql+="and title like ?";
			String title="%"+query.getQtitle()+"%";
			args.add(title);
		}
		if(query.getQcontext()!=null && !"".equals(query.getQcontext())){
			sql+=" and context like ?";
			String context="%"+query.getQcontext()+"%";
			args.add(context);
		}
		return query(args, sql);
	}

	public List<NewsDto> queryById(String id) {
		List<Object> args=new ArrayList<Object>();
		String sql = "select id,newsid,title,context,newsman,newsdate,pic from news where id=?";
		args.add(id);
		return query(args, sql);
	}
	@Override
	public List<NewsDto> queryByFenYe(FenYe fy) {
		List<Object> args=new ArrayList<Object>();
		String sql="select * from "
				+ "(select @rownum:=@rownum+1 AS rownum,n.* from "
				+ "(select @rownum:=0,id,newsid,title,context,newsman,newsdate,pic from news where yes='yes'";
		if(FenYe.search.get("qtitle")!=null && !"".equals(FenYe.search.get("qtitle"))){
			sql+=" and title like ?";
			String title="%"+FenYe.search.get("qtitle")+"%";
			args.add(title);
		}
		if(FenYe.search.get("qcontext")!=null && !"".equals(FenYe.search.get("qcontext"))){
			sql+=" and context like ?";
			String context="%"+FenYe.search.get("qcontext")+"%";
			args.add(context);
		}
		sql+=")n)a where rownum>? and rownum<=?";
		args.add(FenYe.startRow);
		args.add(FenYe.endRow);
		return query(args, sql);
	}
	
	@Override
	public int queryCount(FenYe fy) {
		int rowCount=0;
		List<Object> args=new ArrayList<Object>();
		conn=DataSourceUtil.init().getConn();
		String sql="select count(*) from news where yes='yes' ";
		if(FenYe.search.get("qtitle")!=null && !"".equals(FenYe.search.get("qtitle"))){
			sql+=" and title like ?";
			String title="%"+FenYe.search.get("qtitle")+"%";
			args.add(title);
		}
		if(FenYe.search.get("qcontext")!=null && !"".equals(FenYe.search.get("qcontext"))){
			sql+=" and context like ?";
			String context="%"+FenYe.search.get("qcontext")+"%";
			args.add(context);
		}
		try {
			st=conn.prepareStatement(sql);
			if(args.size()>0){
				for(int i=0;i<args.size();i++){
					st.setObject(i+1, args.get(i));
				}
			}
			rs=st.executeQuery();
			rs.next();
			rowCount=rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DataSourceUtil.init().close(conn, rs, st);
		}
		return rowCount;
	}
//-----------------------------------------------------------------------------
	@Override
	public List<NewsDto> dispose(ResultSet rs) {
		List<NewsDto> ns=new ArrayList<NewsDto>();
		try {
			while(rs.next()){
				NewsDto n = new NewsDto();
				n.setId(rs.getString("id"));
				n.setNewsid(String.valueOf(rs.getInt("newsid")));
				n.setTitle(rs.getString("title"));
				n.setContext(rs.getString("context"));
				n.setNewsdate(rs.getDate("newsdate"));
				n.setNewsman(rs.getString("newsman"));
				n.setPic(rs.getString("pic"));
				ns.add(n);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DataSourceUtil.init().close(conn, rs, st);
		}
		return ns;
	}

	

	

}
