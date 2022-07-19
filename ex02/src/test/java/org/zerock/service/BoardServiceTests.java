package org.zerock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.persistence.DataSourceTests;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {

	@Autowired
	private BoardService service;
	
	@Test
	public void testRegister() {
		BoardVO vo = new BoardVO();
		vo.setTitle("qq11111");
		vo.setContent("qqqqq");
		vo.setWriter("qqq");
		service.register(vo);
		log.info("생성된 게시물 번호 : " + vo.getBno());
	}
	
	@Test
	public void testGet() {
		service.get(13L);
	}
	
	@Test
	public void testRemove() {
		log.info("삭제 : " + service.remove(13L));
	}
	
	@Test
	public void testModify() {
		BoardVO vo = new BoardVO();
		vo.setBno(14L);
		vo.setTitle("수정11");
		vo.setContent("내용1111");
		vo.setWriter("저자11111");
		log.info("수정 : " + service.modify(vo));
	}
	
	@Test
	public void testGetList() {
		service.getList(new Criteria(2,10));
	}
	
}//

