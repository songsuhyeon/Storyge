import React, { useState } from "react";
import * as S from "./Loginstyle.js";
import ProfileImgBox from "./../../components/profileBox/ProfileImgBox";
import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";
import RegisterBtn from "./../../components/button/RegisterBtn";

export default function LoginInfo() {
  const [content, setContent] = useState("");
  const len = `${content.length} / 8`;

  function onChange(e) {
    setContent(e.target.value);
    if (content.length >= 8) {
      alert("닉네임은 8자 이내로 작성해주세요.");
      setContent(content.substr(0, 8));
    }
  }

  return (
    <S.Login>
      <S.LoginInfoText>Set your Nickname</S.LoginInfoText>
      <ProfileImgBox />
      <Box
        className="box"
        component="form"
        sx={{
          "& > :not(style)": { m: 1, width: "25ch" },
        }}
        noValidate
        autoComplete="off"
      >
        <TextField
          id="standard-basic"
          label="NickName"
          variant="standard"
          helperText={len}
          autoFocus={true}
          onChange={onChange}
        />
      </Box>
      <RegisterBtn />
    </S.Login>
  );
}