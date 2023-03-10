import styled from "styled-components";

export const NewDiaryContainer = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  height: 100px;
`;

export const NewDiary = styled.div`
  margin: 60px 0 5px 0;
  padding: 10px 20px 0px 20px;
  display: flex;
  flex-wrap: nowrap;
  overflow-x: auto;
  &::-webkit-scrollbar {
    display: none;
  }
`;

export const NoNewDiary = styled.div`
  margin: 60px 0 0 0;
  padding: 10px 20px;
  height: 70px;
  display: flex;
  justify-content: center;
  align-items: center;
`;

export const ProfileNickName = styled.div`
  font-size: 10px;
  width: 100%;
  text-align: center;
  font-family: "S-CoreDream-3Light";
  color: var(--color-grey-dark);
`;

export const ProfileContainer = styled.div`
  height: 70px;
  width: 70px;
  padding: 2px;
  margin: 0 8px 8px 8px;
  border-radius: 100px;
  outline: 3px solid var(--color-primary);
  background-color: transparent;
  flex: 0 0 auto;
`;

export const Profile = styled.div`
  height: 66px;
  width: 66px;
  background-image: url(${(props) => props.profile});
  background-size: cover;
  border-radius: 100px;
  flex: 0 0 auto;
`;

export const Container = styled.div`
  padding-left: 20px;
  padding-right: 20px;
`;

export const CalendarContainer = styled.div`
  width: 100%;
  padding: 0 0 20px 0;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
`;

export const CalendarBox = styled.div`
  min-height: 10px;
  width: 100%;
  // background: var(--color-grey-light);
  background: var(--color-calendar);
  box-shadow: 0px 16px 40px -4px rgba(112, 144, 176, 0.2);
  border-radius: 12px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-item: center;
  padding: 20px 5px;
`;

export const CalendarToggle = styled.div`
  width: 100%;
  font-family: "S-CoreDream-5Medium";
  font-size: 12px;
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: 10px;
`;

export const ToggleOne = styled.div`
  margin: 0 5px;
`;

export const WiseBox = styled.div`
  width: 100%;
  height: 108px;
  background: var(--color-grey-light);
  box-shadow: 0px 16px 40px -4px rgba(112, 144, 176, 0.2);
  border-radius: 12px;
  margin: 10px 0;
  font-family: "SeoulHangangM";
  text-align: center;
  background: var(--color-calendar);
`;

export const Wise = styled.div`
  padding-top: 25px;
  line-height: 130%;
  font-size: 14px;
  white-space: pre-wrap;
`;

export const WiseFrom = styled.div`
  // color: #b8b8d2;
  color: var(--color-grey-dark);
  padding-top: 10px;
  font-size: 12px;
`;
