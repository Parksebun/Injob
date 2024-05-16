package com.injob.community.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.injob.community.domain.User_boardVo;
import com.injob.community.mapper.User_boardMapper;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

    @Slf4j
    @Controller
    @RequestMapping("/User_board")
    public class User_boardController {
     
        @Autowired
        private User_boardMapper user_boardMapper;
        
        @RequestMapping("/List")
        public ModelAndView list(User_boardVo user_boardVo) {
            List<User_boardVo> user_boardList = user_boardMapper.getUser_boardList(user_boardVo);
            
            ModelAndView mv = new ModelAndView();
            
            mv.addObject("user_boardList", user_boardList);
            mv.setViewName("/user_board/list");
            
            return mv;
        }

    	/*
    	 * @RequestMapping("/WriteForm") public ModelAndView
    	 * writeForm(HttpServletRequest request) { HttpSession session =
    	 * request.getSession(); String user_id = (String)
    	 * session.getAttribute("user_id"); // 세션에서 사용자 아이디 가져오기
    	 * 
    	 * ModelAndView mv = new ModelAndView(); mv.addObject("user_id", user_id);
    	 * mv.setViewName("/user_board/write"); return mv; }
    	 */
        @RequestMapping("/WriteForm")
        public ModelAndView writeForm(HttpServletRequest request) {
            // 현재는 로그인 기능이 구현되지 않았으므로 임의의 값 "1"로 사용자 ID를 설정합니다.
            String userId = "1"; 
            
            ModelAndView mv = new ModelAndView();
            mv.addObject("user_id", userId);
            mv.setViewName("/user_board/write");
            return mv;
        }

        
        @RequestMapping("/Write")
        public ModelAndView write(User_boardVo user_boardVo) {
            user_boardMapper.insertUser_board(user_boardVo);
            
            ModelAndView mv = new ModelAndView();
            mv.setViewName("redirect:/User_board/List");
            return mv;
        }

        @RequestMapping("/UpdateForm")
        public ModelAndView updateForm(User_boardVo user_boardVo) {
            //Long user_id = 1L; // 임의의 사용자 ID로 설정한 예시입니다.
            User_boardVo vo = user_boardMapper.getUser_board(user_boardVo); // 사용자 ID로 게시글을 조회합니다.
            
            ModelAndView mv = new ModelAndView();   
            mv.addObject("vo", vo);
            System.out.println("asldkfj;lasdkjfl;sjdk"+vo.getBoard_id());
            mv.setViewName("/user_board/update");
            return mv;
        }

        @RequestMapping("/Update")
        public String update(User_boardVo user_boardVo) {
            user_boardMapper.updateUser_board(user_boardVo); // 게시글 수정
            
            // 수정된 게시글의 ID와 사용자 ID를 파라미터로 넘겨줌
            return "redirect:/User_board/List?user_id=" + user_boardVo.getUser_id() + "&board_id=" + user_boardVo.getBoard_id();
        }
        
        // 게시글 삭제
        @RequestMapping("/delete")
        public ModelAndView delete(User_boardVo user_boardVo) {
            // 게시물 삭제
            user_boardMapper.deleteUser_board(user_boardVo);
            
            String user_id = "1";
            // 리다이렉트 URL 구성 (사용자 ID와 페이지 번호는 동적으로 설정)
            String redirectUrl = "redirect:/User_board/List?user_id=" + user_boardVo.getUser_id() + "&nowpage=1";
            
            // ModelAndView 객체 생성 후 뷰의 이름 설정하여 리다이렉트
            ModelAndView mv = new ModelAndView();
            mv.setViewName(redirectUrl);
            return mv;
        }

        
        @RequestMapping("/View")
        public ModelAndView view(User_boardVo user_boardVo) {
            // 조회수 증가
            user_boardMapper.incHit(user_boardVo);
            
            // 단일 게시물 조회
            User_boardVo vo = user_boardMapper.getUser_board(user_boardVo);
            ModelAndView mv = new ModelAndView();
            mv.addObject("vo", vo);
            
            mv.setViewName("user_board/view");
            return mv;
        }

        
    }


   

