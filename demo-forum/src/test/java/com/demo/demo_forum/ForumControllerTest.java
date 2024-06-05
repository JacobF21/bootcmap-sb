package com.demo.demo_forum;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.demo.demo_forum.controller.impl.ForumController;
import com.demo.demo_forum.mapper.CommentDTO2Mapper;
import com.demo.demo_forum.mapper.CommentDTOMapper;
import com.demo.demo_forum.mapper.PostDTOMapper;
import com.demo.demo_forum.mapper.UserCommentDTOMapper;
import com.demo.demo_forum.mapper.UserDetailsDTOMapper;
import com.demo.demo_forum.model.Post;
import com.demo.demo_forum.model.User;
import com.demo.demo_forum.model.User.Address;
import com.demo.demo_forum.model.User.Company;
import com.demo.demo_forum.model.User.Address.Location;
import com.demo.demo_forum.model.dto.CommentDTO;
import com.demo.demo_forum.model.dto.PostDTO;
import com.demo.demo_forum.model.dto.UserDetailsDTO;
import com.demo.demo_forum.model.dto.UserDetailsDTO.AddressDTO;
import com.demo.demo_forum.model.dto.UserDetailsDTO.CompanyDTO;
import com.demo.demo_forum.model.dto.UserDetailsDTO.AddressDTO.LocationDTO;
import com.demo.demo_forum.service.ForumService;

@WebMvcTest(ForumController.class)
public class ForumControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private ForumService forumService;

  @MockBean
  private PostDTOMapper postDTOMapper;

  @MockBean
  private CommentDTOMapper commentDTOMapper;

  @MockBean
  private CommentDTO2Mapper commentDTO2Mapper;

  @MockBean
  private UserDetailsDTOMapper userDetailsDTOMapper;

  @MockBean
  private UserCommentDTOMapper userCommentDTOMapper;

  @Test
  void testGetUserDetail() throws Exception {
    List<CommentDTO> expectCommentDTOList = new ArrayList<>();
    expectCommentDTOList.add(CommentDTO.builder().commentId(1L)
        .name("id labore ex et quam laborum").email("Eliseo@gardner.biz")
        .body("laudantium enim quasi est quidem magnam").build());
    expectCommentDTOList.add(CommentDTO.builder().commentId(2L)
        .name("id labore ex et quam laborum").email("Eliseo@gardner.biz")
        .body("laudantium enim quasi est quidem magnam").build());
    expectCommentDTOList.add(CommentDTO.builder().commentId(3L)
        .name("id labore ex et quam laborum").email("Eliseo@gardner.biz")
        .body("laudantium enim quasi est quidem magnam").build());

    when(forumService.getComment(1L).stream().map(commentDTOMapper::map)
        .collect(Collectors.toList())).thenReturn(expectCommentDTOList);

    Post expecPost = new Post(1L, 1L, "sunt aut facere reprehenderit",
        "quia etsuscipit recusandae");

    PostDTO expecPostDTO = PostDTO.builder().postId(expecPost.getPostId())
        .title(expecPost.getTitle()).body(expecPost.getBody())
        .comments(expectCommentDTOList).build();

    when(postDTOMapper.map(expecPost, expectCommentDTOList))
        .thenReturn(expecPostDTO);

    List<PostDTO> expecPostDTOList = new ArrayList<>(List.of(expecPostDTO));

    when(forumService.getPost(1L).stream().map(post -> {
      List<CommentDTO> commentList = forumService.getComment(post.getPostId())
          .stream().map(commentDTOMapper::map).collect(Collectors.toList());
      return postDTOMapper.map(post, commentList);
    }).collect(Collectors.toList())).thenReturn(expecPostDTOList);

    Location expecLocation =
        Location.builder().latitude("-37.3159").longitude("81.1496").build();
    Address expecAddress =
        Address.builder().street("Kulas Light").suite("Apt. 556")
            .city("Gwenborough").zipcode("null").geo(expecLocation).build();
    Company expecCompany = Company.builder().name("Romaguera-Crona")
        .catchPhrase(null).business("harness real-time e-markets").build();
    User expecUser = new User(1L, "Leanne Graham", "Bret", "Sincere@april.biz",
        expecAddress, "1-770-736-8031 x56442", "hildegard.org", expecCompany);
    List<User> expecUserList = new ArrayList<>(List.of(expecUser));

    when(forumService.getUser()).thenReturn(expecUserList);

    LocationDTO locationDTO =
        LocationDTO.builder().latitude(expecLocation.getLatitude())
            .longitude(expecLocation.getLongitude()).build();

    AddressDTO expecAddressDTO = AddressDTO.builder()
        .city(expecAddress.getCity()).street(expecAddress.getStreet())
        .suite(expecAddress.getSuite()).geo(locationDTO).build();

    CompanyDTO expecCompanyDTO =
        CompanyDTO.builder().name(expecCompany.getName())
            .business(expecCompany.getBusiness()).build();

    UserDetailsDTO expecUserDetailsDTO =
        UserDetailsDTO.builder().id(expecUser.getId()).name(expecUser.getName())
            .username(expecUser.getUsername()).email(expecUser.getEmail())
            .address(expecAddressDTO).phone(expecUser.getPhone())
            .website(expecUser.getWebsite()).company(expecCompanyDTO)
            .posts(expecPostDTOList).build();
    List<UserDetailsDTO> expecUserDetailsList = new ArrayList<>(List.of(expecUserDetailsDTO));

    when(userDetailsDTOMapper.map(expecUser, expecPostDTOList)).thenReturn(expecUserDetailsDTO);


    when(expecUserList.stream().map(user -> {
        List<PostDTO> postList =
            forumService.getPost(1L).stream().map(post -> {
              List<CommentDTO> commentList =
                  forumService.getComment(1L).stream()
                      .map(commentDTOMapper::map).collect(Collectors.toList());
              return postDTOMapper.map(post, commentList);
            }).collect(Collectors.toList());
        return userDetailsDTOMapper.map(expecUser, expecPostDTOList);
      }).collect(Collectors.toList())).thenReturn(expecUserDetailsList);
    // when(expecUserList.stream().map(user -> {
    //     List<PostDTO> postList = expecPostDTOList;
    //     userDetailsDTOMapper.map(expecUser, expecPostDTOList);
    //     return expecUserDetailsDTO
    // }).collect(Collectors.toList())).thenReturn(expecUserDetailsList);

    

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
        .andExpect(jsonPath("$[0].address.zipcode").value(null))
        .andExpect(jsonPath("$[0].address.geo.lat").value("-37.3159"))
        .andExpect(jsonPath("$[0].address.geo.lng").value("81.1496"))
        .andExpect(jsonPath("$[0].phone").value("1-770-736-8031 x56442"))
        .andExpect(jsonPath("$[0].website").value("hildegard.org"))
        .andExpect(jsonPath("$[0].company.name").value("Romaguera-Crona"))
        .andExpect(jsonPath("$[0].company.catchPhrase").value(null))
        .andExpect(
            jsonPath("$[0].company.bs").value("harness real-time e-markets"))
        .andExpect(jsonPath("$[0].posts[0].postId").value("1"))
        .andExpect(jsonPath("$[0].posts[0].title")
            .value("sunt aut facere reprehenderit"))
        .andExpect(
            jsonPath("$[0].posts[0].body").value("quia etsuscipit recusandae"));



  }
}

