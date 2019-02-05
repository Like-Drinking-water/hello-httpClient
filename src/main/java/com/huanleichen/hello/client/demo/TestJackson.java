package com.huanleichen.hello.client.demo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestJackson {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        String json = "{\"draw\":1,\"recordsTotal\":12,\"recordsFiltered\":12,\"data\":[{\"id\":38,\"created\":1548131503000,\"updated\":1549166907000,\"username\":\"goodboy\",\"phone\":\"15525655656\",\"email\":\"chen@huanleichen.com\",\"remember\":false},{\"id\":74,\"created\":1548750519000,\"updated\":1548750519000,\"username\":\"admin\",\"phone\":\"15525655656\",\"email\":\"addasfasamin@huanleichen.com\",\"remember\":false},{\"id\":75,\"created\":1548752576000,\"updated\":1548752576000,\"username\":\"admin\",\"phone\":\"15525655656\",\"email\":\"admasfadin@huanleichen.com\",\"remember\":false},{\"id\":86,\"created\":1549166987000,\"updated\":1549166987000,\"username\":\"admin45454\",\"phone\":\"15525655656\",\"email\":\"admin@huanleichen.com\",\"remember\":false},{\"id\":87,\"created\":1549166998000,\"updated\":1549166998000,\"username\":\"fdsdfsds\",\"phone\":\"15525655656\",\"email\":\"admsdasdin@huanleichen.com\",\"remember\":false},{\"id\":88,\"created\":1549167013000,\"updated\":1549167013000,\"username\":\"admindas\",\"phone\":\"15525655656\",\"email\":\"adasdadmin@huanleichen.com\",\"remember\":false},{\"id\":89,\"created\":1549167023000,\"updated\":1549167023000,\"username\":\"adminsadasd\",\"phone\":\"15525655656\",\"email\":\"cheadasdn@huanleichen.com\",\"remember\":false},{\"id\":90,\"created\":1549167034000,\"updated\":1549167034000,\"username\":\"adminasdsaa\",\"phone\":\"15525655656\",\"email\":\"admidasdasn@huanleichen.com\",\"remember\":false},{\"id\":91,\"created\":1549167063000,\"updated\":1549167063000,\"username\":\"adminfsdfsf\",\"phone\":\"15525655656\",\"email\":\"admsdfsdfsin@huanleichen.com\",\"remember\":false},{\"id\":92,\"created\":1549167074000,\"updated\":1549167074000,\"username\":\"admindsfsdf\",\"phone\":\"15525655656\",\"email\":\"adasdadamin@huanleichen.com\",\"remember\":false}],\"error\":null}\n";
        try {
            User user = mapper.readValue(json, User.class);
            System.out.println(user);
            String obj2Json = mapper.writeValueAsString(user);
            System.out.println(obj2Json);
            //获取节点
            JsonNode node = mapper.readTree(json);
            //获取 data 节点
            JsonNode data = node.findPath("data");
            //List<TbUser> tbUsers = mapper.readValue(data.toString(), new TypeReference<List<TbUser>>() {});
            //System.out.println(tbUsers);
            JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, TbUser.class);
            List<TbUser> tbUsers = mapper.readValue(data.toString(), javaType);
            System.out.println(tbUsers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class User {
    private int draw;
    private int recordsTotal;
    private int recordsFiltered;
    private String error;
    private List<TbUser> data;

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(int recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public int getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(int recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<TbUser> getData() {
        return data;
    }

    public void setData(List<TbUser> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "User{" +
                "draw=" + draw +
                ", recordsTotal=" + recordsTotal +
                ", recordsFiltered=" + recordsFiltered +
                ", error='" + error + '\'' +
                ", data=" + data +
                '}';
    }
}

class TbUser {
    private Long id;
    private Date created;
    private Date updated;
    private String username;
    private String phone;
    private String email;
    private Boolean remember;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getRemember() {
        return remember;
    }

    public void setRemember(Boolean remember) {
        this.remember = remember;
    }

    @Override
    public String toString() {
        return "TbUser{" +
                "id=" + id +
                ", created=" + created +
                ", updated=" + updated +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", remember=" + remember +
                '}';
    }
}
