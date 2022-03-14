cmake_minimum_required(VERSION 2.8)

set(lib_name "SDL2Demo")
set(base_dir ${CMAKE_CURRENT_LIST_DIR})

set(src_file
   ${base_dir}/../SDL2/src/main/android/SDL_android_main.c
   ${base_dir}/main.c
)

include_directories(
    ${base_dir}/../SDL2/include
)

add_library(${lib_name} SHARED ${src_file})

target_link_libraries(${lib_name}
                      SDL2
                      GLESv1_CM
                      log
)