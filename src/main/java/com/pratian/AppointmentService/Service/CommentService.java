package com.pratian.AppointmentService.Service;

import com.pratian.AppointmentService.Entities.Comment;

public interface CommentService {
	public Comment getComment(long id);
	public void editComment(Comment c);

}
