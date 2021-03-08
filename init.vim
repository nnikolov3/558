" ~/neovim/plugged is where the plugins are
" getting installed
" Plugin section starts
" -------------------------------------------
call plug#begin('~/neovim/plugged')
" On-demand loading
Plug 'scrooloose/nerdtree', { 'on':  'NERDTreeToggle' }

" plugin provides mappings to easily delete, change
" and add such surroundings in pairs.
" --------------------
Plug 'tpope/vim-surround'
Plug '~/projects/vim-python-magic'
Plug 'tomasiser/vim-code-dark'
Plug 'tpope/vim-markdown'
Plug 'dense-analysis/ale'
Plug 'joshdick/onedark.vim'
let g:ale_set_highlights = 1
let g:ale_echo_msg_format = '%linter%: %s'
let g:ale_linters = {
			\   'python': ['flake8',],
			\   'javascript': ['eslint'],
			\   'html': ['eslint'],
			\   'go': ['go build', 'gometalinter'],
			\   'clojure': ['clj-kondo'],
			\}
let g:ale_python_black_executable = '~/.virtualenvs/neovim/bin/black'
let g:ale_javascript_prettier_use_global = 1
let g:ale_fixers = {
			\   '*': ['remove_trailing_lines', 'trim_whitespace'],
			\   'python': ['isort', 'black'],
			\   'javascriptreact': ['prettier',],
			\   'htmldjango': ['html-beautify'],
			\   'go': ['goimports'],
			\   'javascript': ['prettier',],
			\   'html': ['html-beautify'],
			\}
let g:ale_fix_on_save = 1
let g:ale_completion_enabled = 1
let g:ale_completion_autoimport = 1
let g:ale_echo_msg_error_str = 'E'
let g:ale_echo_msg_warning_str = 'W'
let g:ale_echo_msg_format = '[%linter%] %s [%severity%]'
" Write this in your vimrc file
let g:ale_lint_on_text_changed = 'never'
let g:ale_lint_on_insert_leave = 0
" You can disable this option too
" if you don't want linters to run on opening a file
let g:ale_lint_on_enter = 0
let g:ale_floating_window_border = ['│', '─', '╭', '╮', '╯', '╰']
Plug 'luochen1990/rainbow'
let g:rainbow_active = 1 "set to 0 if you want to enable it later via :RainbowToggle

" Mulitple cursors
" ------------------
Plug 'mg979/vim-visual-multi', {'branch': 'master'}

call plug#end()
" Plugin section ends here
" ------------------

" Other settings go here
" ------------------

let g:onedark_termcolors=256
set termguicolors
syntax enable
set number
set expandtab
set tabstop=4
set shiftwidth=4
set softtabstop=4
setlocal cursorline
set termguicolors t_Co=256

" Autosave
" ------------------
let g:auto_save = 1

" Python support
" Let nvim know where the binaries are

set textwidth=80
" Colorscheme
colorscheme onedark
