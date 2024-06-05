package com.demo.demo_forum.model.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserDetailsDTO {
    private Long id;
    private String name;
    private String username;
    private String email;
    private AddressDTO address;
    private String phone;
    private String website;
    private CompanyDTO company;
    private List<PostDTO> posts;

    @Getter
    @Builder
    public static class AddressDTO {
        private String street;
        private String suite;
        private String city;
        private String zipcode;
        private LocationDTO geo;

        @Getter
        @Builder
        public static class LocationDTO {
            @JsonProperty(value = "lat")
            private String latitude;
            @JsonProperty(value = "lng")
            private String longitude;
        }
    }

    @Getter
    @Builder
    public static class CompanyDTO {
        private String name;
        private String catchPhrase;
        @JsonProperty(value = "bs")
        private String business;
    }
}
