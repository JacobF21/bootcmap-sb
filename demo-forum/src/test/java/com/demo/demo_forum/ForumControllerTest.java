package com.demo.demo_forum;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.demo.demo_forum.controller.impl.ForumController;
import com.demo.demo_forum.mapper.CommentDTO2Mapper;
import com.demo.demo_forum.mapper.CommentDTOMapper;
import com.demo.demo_forum.mapper.PostDTOMapper;
import com.demo.demo_forum.mapper.UserCommentDTOMapper;
import com.demo.demo_forum.mapper.UserDetailsDTOMapper;
import com.demo.demo_forum.model.Comment;
import com.demo.demo_forum.model.Post;
import com.demo.demo_forum.model.User;
import com.demo.demo_forum.model.User.Address;
import com.demo.demo_forum.model.User.Company;
import com.demo.demo_forum.model.User.Address.Location;

import com.demo.demo_forum.service.ForumService;

@WebMvcTest(ForumController.class)
public class ForumControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private ForumService forumService;

  @SpyBean
  private PostDTOMapper postDTOMapper;

  @SpyBean
  private CommentDTOMapper commentDTOMapper;

  @SpyBean
  private CommentDTO2Mapper commentDTO2Mapper;

  @SpyBean
  private UserDetailsDTOMapper userDetailsDTOMapper;

  @SpyBean
  private UserCommentDTOMapper userCommentDTOMapper;

  @Test
  void testGetUserDetail() throws Exception {
    
    List<Comment> expectCommentList = new ArrayList<>();
    expectCommentList.add(new Comment(1L,1L,"id labore ex et quam laborum","Eliseo@gardner.biz","laudantium enim quasi est quidem magnam"));
    when(forumService.getComment(Mockito.anyLong())).thenReturn(expectCommentList);


    List<Post> expecPostList = new ArrayList<>();
    expecPostList.add(new Post(1L, 1L, "sunt aut facere repellat provident occaecati", "quia et suscipit"));
    when(forumService.getPost(Mockito.anyLong())).thenReturn(expecPostList);

    Location expecLocation =
        Location.builder().latitude("-37.3159").longitude("81.1496").build();
    Address expecAddress =
        Address.builder().street("Kulas Light").suite("Apt. 556")
            .city("Gwenborough").zipcode("92998-3874").geo(expecLocation).build();
    Company expecCompany = Company.builder().name("Romaguera-Crona")
        .catchPhrase("abc").business("harness real-time e-markets").build();
    User expecUser = new User(1L, "Leanne Graham", "Bret", "Sincere@april.biz",
        expecAddress, "1-770-736-8031 x56442", "hildegard.org", expecCompany);
    List<User> expecUserList = new ArrayList<>(List.of(expecUser));
    when(forumService.getUser()).thenReturn(expecUserList);

    // LocationDTO locationDTO =
    //     LocationDTO.builder().latitude(expecLocation.getLatitude())
    //         .longitude(expecLocation.getLongitude()).build();

    // AddressDTO expecAddressDTO = AddressDTO.builder()
    //     .city(expecAddress.getCity()).street(expecAddress.getStreet())
    //     .suite(expecAddress.getSuite()).geo(locationDTO).build();

    // CompanyDTO expecCompanyDTO =
    //     CompanyDTO.builder().name(expecCompany.getName())
    //         .business(expecCompany.getBusiness()).build();

    // UserDetailsDTO expecUserDetailsDTO =
    //     UserDetailsDTO.builder().id(expecUser.getId()).name(expecUser.getName())
    //         .username(expecUser.getUsername()).email(expecUser.getEmail())
    //         .address(expecAddressDTO).phone(expecUser.getPhone())
    //         .website(expecUser.getWebsite()).company(expecCompanyDTO)
    //         .posts(expecPostDTOList).build();
    // List<UserDetailsDTO> expecUserDetailsList = new ArrayList<>(List.of(expecUserDetailsDTO));
  
    ResultActions result = mockMvc
        .perform(MockMvcRequestBuilders.get("/jsonplaceholder/get_user"));

    result.andExpect(status().isOk())
          .andExpect(content().contentType("application/json"))
          .andExpect(jsonPath("$[0].id").value(1))
          .andExpect(jsonPath("$[0].name").value("Leanne Graham"))
          .andExpect(jsonPath("$[0].username").value("Bret"))
          .andExpect(jsonPath("$[0].email").value("Sincere@april.biz"))
          .andExpect(jsonPath("$[0].address.street").value("Kulas Light"))
          .andExpect(jsonPath("$[0].address.suite").value("Apt. 556"))
          .andExpect(jsonPath("$[0].address.city").value("Gwenborough"))
          .andExpect(jsonPath("$[0].address.zipcode").value("92998-3874"))
          .andExpect(jsonPath("$[0].address.geo.lat").value("-37.3159"))
          .andExpect(jsonPath("$[0].address.geo.lng").value("81.1496"))
          .andExpect(jsonPath("$[0].phone").value("1-770-736-8031 x56442"))
          .andExpect(jsonPath("$[0].website").value("hildegard.org"))
          .andExpect(jsonPath("$[0].company.name").value("Romaguera-Crona"))
          .andExpect(jsonPath("$[0].company.catchPhrase").value("abc"))
          .andExpect(
            jsonPath("$[0].company.bs").value("harness real-time e-markets"))
          .andExpect(jsonPath("$[0].posts[0].postId").value("1"))
          .andExpect(jsonPath("$[0].posts[0].title")
            .value("sunt aut facere repellat provident occaecati"))
          .andExpect(
            jsonPath("$[0].posts[0].body").value("quia et suscipit"));



  }
}

