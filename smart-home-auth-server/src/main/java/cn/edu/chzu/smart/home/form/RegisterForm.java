package cn.edu.chzu.smart.home.form;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 注册表单
 *
 * @author: EarthChen
 * @date: 2018/06/04
 */
@Data
public class RegisterForm {

    @NotBlank
    @Size(min = 6, max = 20)
    private String username;

    @NotBlank
    @Size(min = 6, max = 20)
    private String password;

    @NotBlank
    @Size(min = 6, max = 20)
    private String repeatPassword;

    @Email
    private String email;

}
