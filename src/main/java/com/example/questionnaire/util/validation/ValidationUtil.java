package com.example.questionnaire.util.validation;

import com.example.questionnaire.HasId;

public class ValidationUtil {

    public static void assureIdConsistent(HasId bean, int id) {
        if (bean.isNew()) {
            bean.setId(id);
        } else if (bean.id() != id) {
            throw new IllegalArgumentException(bean.getClass().getSimpleName() + " must has id=" + id);
        }
    }
}
