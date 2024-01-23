package org.marinfo.mapleinfobe.controller;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

    @GetMapping("/top3")
    public ResponseEntity<TopThreeRank> topThreeController() {
        var rank1 = TopThreeRank.RankUser.builder()
                .characterName("아델")
                .worldName("스카니아")
                .characterClass("아델")
                .characterLevel(287L)
                .characterGuildName("리더")
                .characterImage("https://open.api.nexon.com/static/maplestory/Character/HDLDFHOOPBEBJBCFGPJIADFOMCOHAHLBBNFJGDENBFADHHPMBKKIDKBDNNGDBOJLMFIFFDDHFGOIMDIIAHKHGLDIELPAAHCGCCBKBFGKFOCMONOIKEMAOABKIBEBPHAAKADNLOMJEEHMDDDBJMELIINOAGIBEHMIPIBJKMJMOKAEGAJFNFFEJCGDDAFBBNFLODBGEEMHGNMKIPKHFIFBDCOIBMEDCAALIDLEEHIPCMNBCPDCAJHFKJABPHCCPHII.png")
                .combatPower(720849372L)
                .guildMark(null)
                .guildMarkCustom("iVBORw0KGgoAAAANSUhEUgAAABEAAAARCAYAAAA7bUf6AAAACXBIWXMAAA7EAAAOxAGVKw4bAAACX0lEQVQ4jX2UPWgUQRiGn2+5QoJFSGEh4SpJQCSYZEawEAuLVIpiAilPLqB32bOXFGJhZaW37IEWiRAwkIiNiFpZSIr7Rk4OUaIiclwhFhIsgkXYsdjZy5nCqXZ2vnnmfd/5Ee89w82Y+qZz6cJBvzYGjANR/kcyoO9c+quoiQ4BKs6l88bUN4cAZWAGqIJUw/d4UQMghRJj6k3n0nhIQQI8yifJnHPpYqh7KBI9Bt6rJnv/KHEubRhT2wqAa8BtkGMg086li8bU2wAiURk4Dhy1Nn42gBhTq+Sg1oIxtS3nWmsgJ4GJYAeRqBvW+wPsA/uqyRWAyJhaxbnW6jAoFB8BJp1LL1sbt4ei6wPfQS4NgnWutWZMrQpsGFMvBd9TwESQDtBVTZasjV+DvAO5qtq8Y22jBSCzszfGQIotzIDfItEJ4KJqctPauK2anMnVyBNgRLV5PdjsWRuvlAJgBjgvEnWAXWAyhEcOaLwFeQq8Ad+zNu6pJnetjVdUk/UoKJh1Lq0A54A5YEI1mQewtvEcGABUk8EhG5wTY5ZPA1XVJD48aG1jA/gJvpOHyS6A91kGTDmXrhtTvy/GLE8FO9O5BdlVbS5Z22iD7wKjYfJeAETAJ+BzvgD9UtiyW8ArEMIkwHdVk6XD6sLubYXcOoWdCORUUDOn2lw8sBNve599LFQAI8Coc+l8gD0AVksgRbhnC4C18Qvgq/fZTlDaC5Ay+eX7EfodICsBGXiAHWvjb8BL77MvwAeR6J732YXi2htT75E/C9sBkgF98d5jbVwOgxPeZ3shtN7wm/G/9heAAv9DLXHWKgAAAABJRU5ErkJggg==")
                .rank(1L)
                .build();
        var rank2 = TopThreeRank.RankUser.builder()
                .characterName("도적")
                .worldName("크로아")
                .characterClass("듀얼블레이더")
                .characterLevel(286L)
                .characterGuildName("지존")
                .characterImage("https://open.api.nexon.com/static/maplestory/Character/PFIDHDABADEJNFNGLEAHFNCNNKIENIMKJIBDNAGIDBCDBKCPJGFDKJNBKMCFIOJJCOPNADNGEFGHOCBAOKNJAAPBLHHOGPDEHLDCKPHMEPDEBHOIMLBCOGFKKACJELKGPCMJEFMEJOPBHJIJFAIIODDNBKMEOGGOJNMKLAIALKALPOAOGAAFFFGBMPJKINKDKGMEJMNFNFHJNGEIOGGMJNFEIAPCFOIJIJLHCFAEIHLHNKIMICOCLENICHDIDOPF.png")
                .combatPower(680213276L)
                .guildMark(null)
                .guildMarkCustom("iVBORw0KGgoAAAANSUhEUgAAABEAAAARCAYAAAA7bUf6AAAACXBIWXMAADXTAAA10wEMIUN3AAAAB3RJTUUH5woEEikj+8SX6wAAA29JREFUOI1tlG9I1AcYxz+/n3enpyZlRjpNOzQGUmFN5zZxK0Y6YWbUKMbmH4IWtSAIVkwSFizXFbI1sFXM3KxgV6LppNFeBKPJnLU5tLnNtOa1LTPPWf65O+/u990Ly73pef18vvA8H/jCU0aDg7WCdEG2YI0gR5AliHna/v8gRMnjyVFXV4ckqb29WwUFhwR7BLsEOwVlAtfTYEOwULBCGRkbBW6dO9d7lDgpIeHLIyyV4NMaZ7JUWtqopKT3Ba8IMh9zhiFYBGRdXJzb7QgFI4mOSFRhmsPTNujNbJgK5RqAyxnLJr/v5ro6d+jK/sNr/lqYFPEadh0a+zUf+BtBtmdxrnT3c2nohHTxeTVHpUpw5jDO7g+J6foqv7BfLS39oekZS70XFb78hqUrGapenitBNgHY2hi/Urp7WgdAB0Aa/kL1PCM/NI5BfSAhobmBJKnnlE6CPnI6pe4SVbvyFICt5iSkTs0GwAoTAZYA72VUsXu8lmPGsioLVlY/ituy/dqLfFZZT9jpxOf3gy0CwCSkmmPg9IdngSB6/OyXgLrEKmruvMYRUl6uG8ijrvBrUnp7mfX7MQFMA4AxcJo+CORZ3lZ3xlFqh47PW1uHweh3fQSI0HPhNuvnTBIC3H2lVG/yUXzn+gUfBGz/wkgYIpmbi5ge+hMvcaRjw4HF/coePmhaxWjFL1g4sGEyg+D+IBNBk3EYt8GIGZy7LjFnfe7UuaKTHO8twYvBAHYmiWKkopcJ7PxOHDeJ5eAlF2Wv+yi419/5EGP4EQzY8j2eZVZw1pVe/nb8Bil0fGeHfd+3yWwvesA+wtzCzgpCnMeg5rCdWvdSSgJ/jM1ijFvwjx9+ox3ymuGM1+MZP4FNXveb2k+sDrJAHxOnac8SfUKcalig+sJiWcEJnX6rUp3v7ulswiwHMDfC9SBGs/eHH2+MZq8ibV8D91KSGcRkx3lUus2vva0Wt4ni52vfM/NNBRPnz5K8dm1WPNYL7fDsvI29OLbswt5UtihNalkgqyVaBcRrL4yuJlZqtWn6lF3uzds00Nj4UJJGOjr6H1y9utt4EvIO9iwLXg2j5/qI3iFgNf7LJmBB1A1iip2IDQTbs1Bscdsl109lZW3AsfkQgHJsmQZEh8AFchgQMMFrwfK5LjECdhgWBM8SvvWE+w/nSqrc1NhvKAAAAABJRU5ErkJggg==")
                .rank(2L)
                .build();
        var rank3 = TopThreeRank.RankUser.builder()
                .characterName("수호")
                .worldName("크로아")
                .characterClass("아크")
                .characterLevel(289L)
                .characterGuildName("지존")
                .characterImage("https://open.api.nexon.com/static/maplestory/Character/EEJLLBNIIBLFNNOJMOKGFGDEABEHBGDHAIEGIACEGJDCIJBCGKGFODMIOILEGIIHOHDIEMABJHMJONCFKAGOCGPDIHFEOFDFLFLGDOJNKMKNKMKFDEHGBBMBGHLMGIGEPIJOFOFELNMPGBDDDMEPPNOMCDFBIHJLNDCJNDPKHHFCNDMLJDONCKBADGGPIOIJEBFGPCBOJGGPFNJBAMDHACNHCKOIENLJMOLGNHOLFFEIFMCDKINGPPJGALLMMAOJ.png")
                .combatPower(650329415L)
                .guildMark(null)
                .guildMarkCustom("iVBORw0KGgoAAAANSUhEUgAAABEAAAARCAYAAAA7bUf6AAAACXBIWXMAADXTAAA10wEMIUN3AAAAB3RJTUUH5woEEikj+8SX6wAAA29JREFUOI1tlG9I1AcYxz+/n3enpyZlRjpNOzQGUmFN5zZxK0Y6YWbUKMbmH4IWtSAIVkwSFizXFbI1sFXM3KxgV6LppNFeBKPJnLU5tLnNtOa1LTPPWf65O+/u990Ly73pef18vvA8H/jCU0aDg7WCdEG2YI0gR5AliHna/v8gRMnjyVFXV4ckqb29WwUFhwR7BLsEOwVlAtfTYEOwULBCGRkbBW6dO9d7lDgpIeHLIyyV4NMaZ7JUWtqopKT3Ba8IMh9zhiFYBGRdXJzb7QgFI4mOSFRhmsPTNujNbJgK5RqAyxnLJr/v5ro6d+jK/sNr/lqYFPEadh0a+zUf+BtBtmdxrnT3c2nohHTxeTVHpUpw5jDO7g+J6foqv7BfLS39oekZS70XFb78hqUrGapenitBNgHY2hi/Urp7WgdAB0Aa/kL1PCM/NI5BfSAhobmBJKnnlE6CPnI6pe4SVbvyFICt5iSkTs0GwAoTAZYA72VUsXu8lmPGsioLVlY/ituy/dqLfFZZT9jpxOf3gy0CwCSkmmPg9IdngSB6/OyXgLrEKmruvMYRUl6uG8ijrvBrUnp7mfX7MQFMA4AxcJo+CORZ3lZ3xlFqh47PW1uHweh3fQSI0HPhNuvnTBIC3H2lVG/yUXzn+gUfBGz/wkgYIpmbi5ge+hMvcaRjw4HF/coePmhaxWjFL1g4sGEyg+D+IBNBk3EYt8GIGZy7LjFnfe7UuaKTHO8twYvBAHYmiWKkopcJ7PxOHDeJ5eAlF2Wv+yi419/5EGP4EQzY8j2eZVZw1pVe/nb8Bil0fGeHfd+3yWwvesA+wtzCzgpCnMeg5rCdWvdSSgJ/jM1ijFvwjx9+ox3ymuGM1+MZP4FNXveb2k+sDrJAHxOnac8SfUKcalig+sJiWcEJnX6rUp3v7ulswiwHMDfC9SBGs/eHH2+MZq8ibV8D91KSGcRkx3lUus2vva0Wt4ni52vfM/NNBRPnz5K8dm1WPNYL7fDsvI29OLbswt5UtihNalkgqyVaBcRrL4yuJlZqtWn6lF3uzds00Nj4UJJGOjr6H1y9utt4EvIO9iwLXg2j5/qI3iFgNf7LJmBB1A1iip2IDQTbs1Bscdsl109lZW3AsfkQgHJsmQZEh8AFchgQMMFrwfK5LjECdhgWBM8SvvWE+w/nSqrc1NhvKAAAAABJRU5ErkJggg==")
                .rank(3L)
                .build();

        var rankUser = new ArrayList<TopThreeRank.RankUser>();

        rankUser.add(rank1);
        rankUser.add(rank2);
        rankUser.add(rank3);

        var topThreeRankResult = TopThreeRank.builder()
                .rankUsers(rankUser).build();

        return ResponseEntity.ok(topThreeRankResult);
    }

    @Getter
    @Setter
    @ToString
    @Builder
    public static class TopThreeRank{
        @JsonUnwrapped
        private List<RankUser> rankUsers;

        @Getter
        @Setter
        @ToString
        @Builder
        public static class RankUser{
            // 캐릭터 기본 정보 조회
            private String characterName;
            private String worldName;
            private String characterClass;
            private Long characterLevel;
            private String characterGuildName;
            private String characterImage;
            // 캐릭터 종합 능력치 정보 조회
            private Long combatPower;
            // 길드 기본 정보 조회
            private String guildMark;
            private String guildMarkCustom;
            // 통계 로직 필요.
            private Long rank;
        }
    }
}
