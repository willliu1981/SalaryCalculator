package com.v4.listener;

import java.util.List;

import com.v4.model.ListDialogResult;
import com.v4.model.Result;

import com.v4.model.User;

public interface ListDialogDispatchable<T extends ListDialogResult>
		extends Dispatchable<T> {

}
