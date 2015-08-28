package airbnb;

/**
 * 给定一个CSV文件，格式是 “some_name|some_address|some_phone|some_job”，
 * 
 * 要求输出Json format “{name:some_name, address:some_addres,phone:some_phone,
 * job:some_job}”
 *
 * 特殊情况为两个引号之间的分号，不可作为分割字符
 * 
 * John,Smith,john.smith@gmail.com,Los Angeles,1
 * 
 * Jane,Roberts,janer@msn.com,"San Francisco, CA",0
 * 
 * "Alexandra ""Alex""",Menendez,alex.menendez@gmail.com,Miami,1
 * 
 * """Alexandra Alex"""
 * 
 * John|Smith|john.smith@gmail.com|Los Angeles|1
 * 
 * Jane|Roberts|janer@msn.com|San Francisco, CA|0
 * 
 * Alexandra "Alex"|Menendez|alex.menendez@gmail.com|Miami|1
 * 
 * "Alexandra Alex"
 */
public class ParseCSV {

}
