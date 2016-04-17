package hit.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
/**
 * 
 * @author 作者: 如今我已·剑指天涯
 * @Description:自定义日期转换器
 *创建时间:2016年4月16日上午9:14:00
 */
public class DateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
		try {
			//转换成功，直接返回
			return simpleDateFormat.parse(source);
		} catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}