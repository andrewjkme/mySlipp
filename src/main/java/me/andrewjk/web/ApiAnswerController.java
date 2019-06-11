package me.andrewjk.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.andrewjk.domain.Answer;
import me.andrewjk.domain.AnswerRepository;
import me.andrewjk.domain.Question;
import me.andrewjk.domain.QuestionRepository;
import me.andrewjk.domain.User;

@RestController
@RequestMapping("/api/questions/{questionId}/answers")
public class ApiAnswerController {
	@Autowired
	private QuestionRepository questionRepositoy;
	
	@Autowired
	private AnswerRepository answerRepository;
	
	@PostMapping("")
	public Answer create(@PathVariable Long questionId, String contents, HttpSession session) {
		if(!HttpSessionUtils.isLoginUser(session)) {
			return null;
		}
		User user = HttpSessionUtils.getUserFromSession(session);
		Question question = questionRepositoy.findById(questionId).get();
		Answer answer = new Answer(user, question, contents);
		return answerRepository.save(answer);
		
	}
}
