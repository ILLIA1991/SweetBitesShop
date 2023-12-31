import { lazy } from "react";
import { Routes, Route, Navigate } from "react-router-dom";
import { Layout } from "../Layout/Layout";
import "slick-carousel/slick/slick.css"; 
import "slick-carousel/slick/slick-theme.css";
import "swiper/css";
import 'swiper/css/pagination';
import 'swiper/css/navigation';

const Home = lazy(() => import("../../pages/Home/Home"));

export const App = () => {
  return (
    <>
      <Routes>
        <Route path="/" element={<Layout />}>
          <Route path="/" element={<Home />} />
          <Route path="*" element={<Navigate to="/" />} />
        </Route>
      </Routes>
    </>
  );
};

export default App;
