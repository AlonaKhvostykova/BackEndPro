package lesson02_2106.varFromStanislav.backEnd.service.validation;

import lesson02_2106.varFromStanislav.backEnd.dto.RequestDto;

import java.util.ArrayList;
import java.util.List;

public class Validation {
    public List<String> validate(RequestDto requestDto) {
      List<String> errors = new ArrayList<>();

      if (requestDto.getTitle() == null) {errors.add("Имя задачи не может быть null");}
      if (requestDto.getDescription() == null) {errors.add("Описание не может быть null");}
      if (requestDto.getTitle().length() < 3) {errors.add("Длина имени задачи не может быть меньше 3 символов");}
      if (requestDto.getTitle().length() > 15) {errors.add("Длина имени задачи не может быть больше 15 символов");}
      if (requestDto.getDescription().length() < 3) {errors.add("Длина описания задачи не может быть меньше 3 символов");}
      if (requestDto.getDescription().length() > 25) {errors.add("Длина описания задачи не может быть больше 25 символов");}

      return errors;
    }

}
