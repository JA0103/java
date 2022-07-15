package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

   private BoardMapper mapper;
   
   @Override
   public void register(BoardVO vo) {
      log.info("register=========");
//      mapper.insert(vo);
      mapper.insertSelectKey(vo);
   }

   @Override
   public BoardVO get(Long bno) {
      
      return mapper.read(bno);
   }

   @Override
   public int modify(BoardVO vo) {
      
      return mapper.update(vo);
   }

   @Override
   public List<BoardVO> getList() {
      
      return mapper.getList();
   }

	@Override
	public int remove(Long bno) {
		return mapper.delete(bno);
	}
   
      
}