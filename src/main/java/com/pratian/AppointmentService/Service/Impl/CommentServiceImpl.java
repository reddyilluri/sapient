package com.pratian.AppointmentService.Service.Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pratian.AppointmentService.Entities.Comment;
import com.pratian.AppointmentService.Repository.CommentRepo;
import com.pratian.AppointmentService.Repository.IAppointmentRepo;
import com.pratian.AppointmentService.Service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentRepo commentrepo;
	@Autowired
	IAppointmentRepo appointmentrepo;
	@Override
	public Comment getComment(long id) {
		
		return appointmentrepo.getAppointmentById(id).getComment();
	}
	@Override
	public void editComment(Comment c) {
		
		Comment comment1=commentrepo.getCommentById(c.getId());
		comment1.setComment_name(c.getComment_name());
		commentrepo.save(comment1);
		
	}
	
	
}
