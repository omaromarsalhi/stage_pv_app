import {
  HomeIcon,
  UserCircleIcon,
  TableCellsIcon,
  InformationCircleIcon,
  ServerStackIcon,
  RectangleStackIcon
} from "@heroicons/react/24/solid";
import { Home, Profile, Tables, Notifications, GeneratePv, Test, InsertMarks } from "@/pages/dashboard";
import { SignIn, SignUp } from "@/pages/auth";
import { RiAiGenerate } from "react-icons/ri";

const icon = {
  className: "w-5 h-5 text-inherit",
};

export const routes = [
  {
    layout: "dashboard",
    pages: [
      {
        icon: <UserCircleIcon {...icon} />,
        name: "profile",
        path: "/profile",
        element: <Profile />,
      },
      {
        icon: <RiAiGenerate {...icon} />,
        name: "generatePv",
        path: "/generatePv",
        element: <GeneratePv />,
      },
      {
        icon: <RiAiGenerate {...icon} />,
        name: "insertMarks",
        path: "/insertMarks",
        element: <InsertMarks />,
      },
      {
        icon: <UserCircleIcon {...icon} />,
        name: "test",
        path: "/test",
        element: <Test />,
      },
      {
        icon: <HomeIcon {...icon} />,
        name: "dashboard",
        path: "/home",
        element: <Home />,
      },
      {
        icon: <TableCellsIcon {...icon} />,
        name: "tables",
        path: "/tables",
        element: <Tables />,
      },
      {
        icon: <InformationCircleIcon {...icon} />,
        name: "notifications",
        path: "/notifications",
        element: <Notifications />,
      },
    ],
  },
  {
    title: "auth pages",
    layout: "auth",
    pages: [
      {
        icon: <ServerStackIcon {...icon} />,
        name: "sign in",
        path: "/sign-in",
        element: <SignIn />,
      },
      {
        icon: <RectangleStackIcon {...icon} />,
        name: "sign up",
        path: "/sign-up",
        element: <SignUp />,
      },
    ],
  },
];

export default routes;
