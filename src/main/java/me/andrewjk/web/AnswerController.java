package me.andrewjk.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import me.andrewjk.domain.Answer;
import me.andrewjk.domain.AnswerRepository;
import me.andrewjk.domain.Question;
import me.andrewjk.domain.QuestionRepository;
import me.andrewjk.domain.User;

@Controller
@RequestMapping("/questions/{questionId}/answers")
public class AnswerController {
	@Autowired
	private QuestionRepository questionRepositoy;
	
	@Autowired
	private AnswerRepository answerRepository;
	
	@PostMapping("")
	public String create(@PathVariable Long questionId, String contents, HttpSession session) {
		if(!HttpSessionUtils.isLoginUser(session)) {
			return "redirect:/users/loginForm";
		}
		User user = HttpSessionUtils.getUserFromSession(session);
		Question question = questionRepositoy.findById(questionId).get();
		Answer answer = new Answer(user, question,contents);
		
		answerRepository.save(answer);
		
		return String.format("redirect:/questions/%d", questionId);
	}
}
