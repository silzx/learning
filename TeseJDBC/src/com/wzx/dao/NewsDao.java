package com.wzx.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wzx.basedao.BaseDao;
import com.wzx.dto.NewsDto;
import com.wzx.dto.Query;
import com.wzx.util.DataSourceUtil;
@SuppressWarnings("unchecked")
public class NewsDao extends BaseDao {
	/*
	 * 1.根据id删除新闻-- 
	 * 2.查询所有的新闻-- 
	 * 3.根据标题,内容模糊查询新闻 like --- 
	 * 4.添加新闻日期2017-09-18
	 * 5.修改新闻,根据id 
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
		String sql = "select * from news where yes='yes'";
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
		//sql+=" and yes='yes'";
		System.out.println(sql);
		return query(args, sql);
	}

	public NewsDto queryById(int id) {
		List<Object> args=new ArrayList<Object>();
		String sql = "select id,newsid,title,context,newsman,newsdate,pic from news where id=?";
		args.add(id);
		return (NewsDto) query(args, sql);
	}
//-----------------------------------------------------------------------------
	@Override
	public List<NewsDto> dispose(ResultSet rs) {
		List<NewsDto> ns=new ArrayList<NewsDto>();
		try {
			while(rs.next()){
				NewsDto n = new NewsDto();
				n.setId(rs.getString("id"));
				n.setNewsid(rs.getInt("newsid"));
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
